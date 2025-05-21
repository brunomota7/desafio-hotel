package br.com.desafio.service;

import br.com.desafio.dto.request.ResevarQuartoRequestDTO;
import br.com.desafio.dto.response.ResevaResponseDTO;
import br.com.desafio.exceptions.QuartoNotFoundException;
import br.com.desafio.exceptions.ResevaNotFoundException;
import br.com.desafio.mapper.ResevaMapper;
import br.com.desafio.model.Quarto;
import br.com.desafio.model.Reseva;
import br.com.desafio.repository.HotelRepository;
import br.com.desafio.repository.QuartoRepository;
import br.com.desafio.repository.ResevaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResevaService {

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private ResevaRepository resevaRepository;

    @Transactional
    public ResponseEntity<?> resevarQuarto(String codgQuarto, ResevarQuartoRequestDTO dto) {
        Quarto quarto = quartoRepository.findById(codgQuarto)
                .orElseThrow(() -> new QuartoNotFoundException("Quarto de número " + codgQuarto + " não encontrado"));

        if (quarto.isResevado()) {
            return ResponseEntity.status(403).body("O querto de número " + codgQuarto + " já foi resevado.");
        } else {
            Reseva reseva = Reseva.builder()
                    .nomeCliente(dto.getNomeCliente())
                    .dataCheckIn(dto.getDataCheckIn())
                    .dataCheckOut(dto.getDataCheckOut())
                    .quarto(quarto)
                    .build();

            resevaRepository.save(reseva);
            quarto.setResevado(true);
            return ResponseEntity.ok(ResevaMapper.toDTO(reseva));
        }
    }

    @Transactional
    public void cancelarReseva(Long idReseva) {
        Reseva reseva = resevaRepository.findById(idReseva)
                .orElseThrow(() -> new ResevaNotFoundException("Reseva de ID " + idReseva + " não encontrada."));
        Quarto quarto = reseva.getQuarto();

        quarto.setResevado(false);
        quartoRepository.save(quarto);
        resevaRepository.delete(reseva);
    }

    public List<ResevaResponseDTO> getAllResevas() {
        return resevaRepository.findAll().stream()
                .map(ResevaMapper::toDTO)
                .toList();
    }

    public ResevaResponseDTO getResevaById(Long id) {
        Reseva reseva = resevaRepository.findById(id)
                .orElseThrow(() -> new ResevaNotFoundException("Reseva de ID " + id + " não encontrada."));
        return ResevaMapper.toDTO(reseva);
    }

}
