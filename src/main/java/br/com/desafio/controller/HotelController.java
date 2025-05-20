package br.com.desafio.controller;

import br.com.desafio.dto.request.HotelRequestDTO;
import br.com.desafio.dto.request.QuartoRequestDTO;
import br.com.desafio.dto.response.HotelResponseDTO;
import br.com.desafio.dto.response.QuartoResponseDTO;
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
        return ResponseEntity.ok("Hotel cadastrado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<HotelResponseDTO>> getAllHotel() {
        return ResponseEntity.ok(hotelService.getAllHotel());
    }

    @PostMapping("/add-quarto")
    public ResponseEntity<?> cadastrarQuarto(@RequestBody @Valid QuartoRequestDTO dto) {
        hotelService.addQuarto(dto);
        return ResponseEntity.ok("Quarto adicionado com sucesso!");
    }

    @GetMapping("/quartos")
    public ResponseEntity<List<QuartoResponseDTO>> getAllQuartos() {
        return ResponseEntity.ok(hotelService.getAllQuarto());
    }

    @PatchMapping("/{codgQuarto}/resevar")
    public ResponseEntity<?> resevarQuarto(@PathVariable String codgQuarto, @RequestParam boolean resevado) {
        hotelService.resevarQuarto(codgQuarto, resevado);
        return ResponseEntity.ok("Quarto " + codgQuarto + ", resevado com sucesso!");
    }

    @GetMapping("/quartos/disponiveis")
    public ResponseEntity<List<QuartoResponseDTO>> listarQuartosDisponiveis() {
        return ResponseEntity.ok(hotelService.listarQuartosDisponiveis());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<HotelResponseDTO>> buscarPublicamente(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cidade
    ) {
        return ResponseEntity.ok(hotelService.buscarPublicamente(nome, cidade));
    }

}
