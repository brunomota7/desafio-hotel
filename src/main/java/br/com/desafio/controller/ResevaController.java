package br.com.desafio.controller;

import br.com.desafio.dto.request.ResevarQuartoRequestDTO;
import br.com.desafio.dto.response.ResevaResponseDTO;
import br.com.desafio.service.ResevaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reseva")
public class ResevaController {

    @Autowired
    private ResevaService resevaService;

    @PostMapping("/{numQuarto}")
    public ResponseEntity<?> resevarQuarto(@PathVariable int numQuarto, @RequestBody @Valid ResevarQuartoRequestDTO dto) {
        return resevaService.resevarQuarto(numQuarto, dto);
    }

    @PostMapping("/cancelar/{idReseva}")
    public ResponseEntity<?> cancelarReseva(@PathVariable Long idReseva) {
        resevaService.cancelarReseva(idReseva);
        return ResponseEntity.ok("Reseva concelada!");
    }

    @GetMapping
    public ResponseEntity<List<ResevaResponseDTO>> getAllResevas() {
        return ResponseEntity.ok(resevaService.getAllResevas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResevaResponseDTO> getResevaById(@PathVariable Long id) {
        return ResponseEntity.ok(resevaService.getResevaById(id));
    }

}
