package br.com.desafio.service;

import br.com.desafio.dto.request.ResevarQuartoRequestDTO;
import br.com.desafio.dto.response.ReservaResponseDTO;
import br.com.desafio.exceptions.QuartoNotFoundException;
import br.com.desafio.exceptions.ReservaNotFoundException;
import br.com.desafio.mapper.ReservaMapper;
import br.com.desafio.model.Quarto;
import br.com.desafio.model.Reserva;
import br.com.desafio.repository.QuartoRepository;
import br.com.desafio.repository.ResevaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private ResevaRepository reservaRepository;

    @Transactional
    public ResponseEntity<String> reservarQuarto(Long id, ResevarQuartoRequestDTO dto) {
        Quarto quarto = quartoRepository.findById(id)
                .orElseThrow(() -> new QuartoNotFoundException("Quarto não encontrado"));

        if (quarto.isResevado()) return ResponseEntity.status(422)
                .body("O quarto de número \" + numQuarto + \" já foi reservado.");

        if (dto.getQuantPessoas() > quarto.getCapacidade()) return ResponseEntity.status(409)
                .body("Número de pessoas superior a capacidade do quarto. Tente novamente.");

        Reserva reserva = Reserva.builder()
                .nomeCliente(dto.getNomeCliente())
                .contato(dto.getContato())
                .dataCheckIn(dto.getDataCheckIn())
                .dataCheckOut(dto.getDataCheckOut())
                .quantPessoas(dto.getQuantPessoas())
                .quarto(quarto)
                .build();

        reservaRepository.save(reserva);
        quarto.setResevado(true);

        return ResponseEntity.status(201)
                .body("Reseva realizada com sucesso!");
    }

    @Transactional
    public void cancelarReserva(Long idReserva) {
        Reserva reserva = reservaRepository.findById(idReserva)
                .orElseThrow(() -> new ReservaNotFoundException("Reserva de ID " + idReserva + " não encontrada."));
        Quarto quarto = reserva.getQuarto();

        quarto.setResevado(false);
        quartoRepository.save(quarto);
        reservaRepository.delete(reserva);
    }

    public List<ReservaResponseDTO> getAllReservas() {
        return reservaRepository.findAll().stream()
                .map(ReservaMapper::toDTO)
                .toList();
    }

    public ReservaResponseDTO getReservaById(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ReservaNotFoundException("Reseva de ID " + id + " não encontrada."));
        return ReservaMapper.toDTO(reserva);
    }

}
