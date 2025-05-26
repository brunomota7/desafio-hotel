package br.com.desafio.controller;

import br.com.desafio.dto.request.ResevarQuartoRequestDTO;
import br.com.desafio.dto.response.ReservaResponseDTO;
import br.com.desafio.model.Quarto;
import br.com.desafio.repository.QuartoRepository;
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

    @PostMapping("/{id}")
    public ResponseEntity<?> resevarQuarto(@PathVariable Long id, @RequestBody @Valid ResevarQuartoRequestDTO dto) {
        return reservaService.reservarQuarto(id, dto);
    }

    @PostMapping("/cancelar/{idReserva}")
    public ResponseEntity<?> cancelarReserva(@PathVariable Long idReserva) {
        reservaService.cancelarReserva(idReserva);
        return ResponseEntity.status(204).build();
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> getAllReservas() {
        return ResponseEntity.status(200)
                .body(reservaService.getAllReservas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> getReservaById(@PathVariable Long id) {
        return ResponseEntity.status(200)
                .body(reservaService.getReservaById(id));
    }

}
