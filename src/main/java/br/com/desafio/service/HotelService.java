package br.com.desafio.service;

import br.com.desafio.dto.request.HotelRequestDTO;
import br.com.desafio.dto.request.QuartoRequestDTO;
import br.com.desafio.dto.response.HotelResponseDTO;
import br.com.desafio.dto.response.QuartoResponseDTO;
import br.com.desafio.exceptions.HotelNotFoundException;
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

    @Transactional
    public void createHotel(HotelRequestDTO dto) {
        Hotel hotel = Hotel.builder()
                .nome(dto.getNome())
                .cidade(dto.getCidade())
                .endereco(dto.getEndereco())
                .imagemUrl(dto.getImagemUrl())
                .build();

        hotelRepository.save(hotel);
    }

    public List<HotelResponseDTO> getAllHotel() {
        return hotelRepository.findAll()
                .stream()
                .map(HotelMapper::toDTO)
                .toList();
    }

    public List<HotelResponseDTO> buscarPublicamente(String nome, String cidade) {
        return hotelRepository.buscarPublicamente(nome, cidade)
                .stream()
                .map(HotelMapper::toDTO)
                .toList();
    }

    public ResponseEntity<?> updateHotelInfos(Long id, HotelRequestDTO dto) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel de ID " + id + " não encontrado. Tente novamente!"));

        hotel.setNome(dto.getNome());
        hotel.setCidade(dto.getCidade());
        hotel.setEndereco(dto.getEndereco());
        hotel.setImagemUrl(dto.getImagemUrl());

        hotelRepository.save(hotel);

        return ResponseEntity.ok("Informações atualizadas com sucesso!");
    }

    public void deleteHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel de ID " + id + " não encontrado. Tente novamente!"));

        hotelRepository.delete(hotel);
    }

}
