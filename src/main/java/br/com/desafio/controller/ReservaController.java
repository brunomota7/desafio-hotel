package br.com.desafio.controller;

import br.com.desafio.dto.request.ResevarQuartoRequestDTO;
import br.com.desafio.dto.response.ReservaResponseDTO;
import br.com.desafio.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/{numQuarto}")
    public ResponseEntity<?> resevarQuarto(@PathVariable int numQuarto, @RequestBody @Valid ResevarQuartoRequestDTO dto) {
        return reservaService.resevarQuarto(numQuarto, dto);
    }

    @PostMapping("/cancelar/{idReserva}")
    public ResponseEntity<?> cancelarReserva(@PathVariable Long idReserva) {
        reservaService.cancelarReserva(idReserva);
        return ResponseEntity.ok("Reserva concelada!");
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> getAllReservas() {
        return ResponseEntity.ok(reservaService.getAllReservas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> getReservaById(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.getReservaById(id));
    }

}
