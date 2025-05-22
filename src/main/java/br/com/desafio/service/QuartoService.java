package br.com.desafio.service;

import br.com.desafio.dto.request.QuartoRequestDTO;
import br.com.desafio.dto.request.ResevarQuartoRequestDTO;
import br.com.desafio.dto.response.QuartoResponseDTO;
import br.com.desafio.exceptions.HotelNotFoundException;
import br.com.desafio.exceptions.QuartoNotFoundException;
import br.com.desafio.exceptions.ResevaNotFoundException;
import br.com.desafio.mapper.QuartoMapper;
import br.com.desafio.model.Hotel;
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
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Transactional
    public void addQuarto(Long id, QuartoRequestDTO dto) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() ->new HotelNotFoundException("Hotel de ID " + id + " não encontrado"));

        Quarto quarto = Quarto.builder()
                .resevado(dto.isResevado())
                .diaria(dto.getDiaria())
                .capacidade(dto.getCapacidade())
                .hotel(hotel)
                .imagemUrl(dto.getImagemUrl())
                .build();

        quartoRepository.save(quarto);
    }

    public List<QuartoResponseDTO> getAllQuarto() {
        return quartoRepository.findAll().stream()
                .map(QuartoMapper::toDTO).toList();
    }

    public List<QuartoResponseDTO> listarQuartosPorHotel(String nome) {
        return quartoRepository.findByHotel(nome)
                .stream()
                .map(QuartoMapper::toDTO)
                .toList();
    }

    public List<QuartoResponseDTO> listarQuartosDisponiveis() {
        return quartoRepository.findByResevadoFalse().stream()
                .map(QuartoMapper::toDTO).toList();
    }

    public List<QuartoResponseDTO> listaQuartosResevados() {
        return quartoRepository.findByResevadoTrue().stream()
                .map(QuartoMapper::toDTO)
                .toList();
    }

}
