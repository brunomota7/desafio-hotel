package br.com.desafio.dto.request;

import br.com.desafio.model.Quarto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResevarQuartoRequestDTO {
    private String nomeCliente;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private int quantPessoas;
    private Quarto quarto;
}
