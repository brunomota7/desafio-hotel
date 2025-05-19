package br.com.desafio.service;

import br.com.desafio.dto.request.HotelRequestDTO;
import br.com.desafio.dto.request.QuartoRequestDTO;
import br.com.desafio.dto.response.HotelResponseDTO;
import br.com.desafio.dto.response.QuartoResponseDTO;
import br.com.desafio.exceptions.QuartoNotFoundException;
import br.com.desafio.mapper.HotelMapper;
import br.com.desafio.mapper.QuartoMapper;
import br.com.desafio.model.Hotel;
import br.com.desafio.model.Quarto;
import br.com.desafio.repository.HotelRepository;
import br.com.desafio.repository.QuartoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    public void createHotel(HotelRequestDTO dto) {
        Hotel hotel = Hotel.builder()
                .nome(dto.getNome())
                .endereco(dto.getEndereco())
                .build();

        hotelRepository.save(hotel);
    }

    public List<HotelResponseDTO> getAllHotel() {
        return hotelRepository.findAll().stream()
                .map(HotelMapper::toDTO).toList();
    }

    @Transactional
    public void addQuarto(QuartoRequestDTO dto) {
        Quarto quarto = Quarto.builder()
                .resevado(dto.isResevado())
                .diaria(dto.getDiaria())
                .hotel(dto.getHotel())
                .imagemUrl(dto.getImagemUrl())
                .build();

        quartoRepository.save(quarto);
    }

    public List<QuartoResponseDTO> getAllQuarto() {
        return quartoRepository.findAll().stream()
                .map(QuartoMapper::toDTO).toList();
    }

    private Quarto getQuartoOrThrow(String codgQuarto) {
        return quartoRepository.findById(codgQuarto)
                .orElseThrow(() -> new QuartoNotFoundException("Quarto de número " + codgQuarto + " não encontrado"));
    }

    public void mudarStatusReseva(String codgQuarto, boolean resevado) {
        Quarto quarto = getQuartoOrThrow(codgQuarto);
        quarto.setResevado(resevado);
        quartoRepository.save(quarto);
    }

    public List<QuartoResponseDTO> listarQuartosDisponiveis() {
        return quartoRepository.findByDisponivelTrue().stream()
                .map(QuartoMapper::toDTO).toList();
    }

}
