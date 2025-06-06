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
        return ResponseEntity.status(201)
                .body("Quarto adicionado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<QuartoResponseDTO>> getAllQuartos() {
        return ResponseEntity.status(200)
                .body(quartoService.getAllQuarto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuartoResponseDTO> getQuartoById(@PathVariable Long id) {
        return ResponseEntity.status(200)
                .body(quartoService.getQuartoById(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<QuartoResponseDTO>> buscarPeloNomeHotel(@RequestParam String nome) {
        return ResponseEntity.status(200)
                .body(quartoService.listarQuartosPorHotel(nome));
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<QuartoResponseDTO>> listarQuartosDisponiveis() {
        return ResponseEntity.status(200)
                .body(quartoService.listarQuartosDisponiveis());
    }

    @GetMapping("/reservados")
    public ResponseEntity<List<QuartoResponseDTO>> listaQuartosReservados() {
        return ResponseEntity.status(200)
                .body(quartoService.listaQuartosResevados());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizaInfosQuarto(@PathVariable Long id, @RequestBody @Valid QuartoRequestDTO dto) {
        quartoService.updateQuartoInfo(id, dto);
        return ResponseEntity
                .ok("Informações do quarto " + dto.getNumQuarto() + " atualizadas com sucesso!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuarto(@PathVariable Long id) {
        quartoService.deleteQuarto(id);
        return ResponseEntity.status(200)
                .body("Quarto removido com sucesso!");
    }

}
