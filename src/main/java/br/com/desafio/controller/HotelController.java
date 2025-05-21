package br.com.desafio.controller;

import br.com.desafio.dto.request.HotelRequestDTO;
import br.com.desafio.dto.response.HotelResponseDTO;
import br.com.desafio.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarHotel(@RequestBody @Valid HotelRequestDTO dto) {
        hotelService.createHotel(dto);
        return ResponseEntity.ok("Hotel cadastrado com sucesso!");
    }

    @GetMapping("/hoteis")
    public ResponseEntity<List<HotelResponseDTO>> getAllHotel() {
        return ResponseEntity.ok(hotelService.getAllHotel());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<HotelResponseDTO>> buscarPublicamente(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cidade
    ) {
        return ResponseEntity.ok(hotelService.buscarPublicamente(nome, cidade));
    }

}
