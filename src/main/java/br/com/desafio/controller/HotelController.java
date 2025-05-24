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
@RequestMapping("/hoteis")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarHotel(@RequestBody @Valid HotelRequestDTO dto) {
        hotelService.createHotel(dto);
        return ResponseEntity.status(201)
                .body("Hotel cadastrado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<HotelResponseDTO>> getAllHotel() {
        return ResponseEntity.status(200)
                .body(hotelService.getAllHotel());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<HotelResponseDTO>> buscarPublicamente(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cidade
    ) {
        return ResponseEntity.status(200)
                .body(hotelService.buscarPublicamente(nome, cidade));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarInfosHote(
            @PathVariable Long id, @RequestBody @Valid HotelRequestDTO dto) {
        hotelService.updateHotelInfos(id, dto);
        return ResponseEntity
                .ok("Informações do hotel atualizadas com sucesso!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.status(200)
                .body("Hotel de ID " + id + " excluído com sucesso!");
    }

}
