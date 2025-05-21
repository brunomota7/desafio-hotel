package br.com.desafio.controller;

import br.com.desafio.dto.request.ResevarQuartoRequestDTO;
import br.com.desafio.service.ResevaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resevar")
public class ResevaController {

    @Autowired
    private ResevaService resevaService;

    @PostMapping("/{codgQuarto}")
    public ResponseEntity<?> resevarQuarto(@PathVariable String codgQuarto, @RequestBody ResevarQuartoRequestDTO dto) {
        return resevaService.resevarQuarto(codgQuarto, dto);
    }

    @PostMapping("/cancelar/{idReseva}")
    public ResponseEntity<?> cancelarReseva(@PathVariable Long idReseva) {
        resevaService.cancelarReseva(idReseva);
        return ResponseEntity.ok("Reseva concelada!");
    }

}
