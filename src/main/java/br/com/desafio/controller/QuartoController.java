package br.com.desafio.controller;

import br.com.desafio.dto.request.QuartoRequestDTO;
import br.com.desafio.dto.response.QuartoResponseDTO;
import br.com.desafio.service.QuartoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quartos")
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    @PostMapping("/add/{id}")
    public ResponseEntity<?> cadastrarQuarto(@PathVariable Long id, @RequestBody @Valid QuartoRequestDTO dto) {
        quartoService.addQuarto(id, dto);
        return ResponseEntity.ok("Quarto adicionado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<QuartoResponseDTO>> getAllQuartos() {
        return ResponseEntity.ok(quartoService.getAllQuarto());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<QuartoResponseDTO>> buscarPeloNomeHotel(@RequestParam String nome) {
        return ResponseEntity.ok(quartoService.listarQuartosPorHotel(nome));
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<QuartoResponseDTO>> listarQuartosDisponiveis() {
        return ResponseEntity.ok(quartoService.listarQuartosDisponiveis());
    }

    @GetMapping("/resevados")
    public ResponseEntity<List<QuartoResponseDTO>> listaQuartosResevados() {
        return ResponseEntity.ok(quartoService.listaQuartosResevados());
    }

}
