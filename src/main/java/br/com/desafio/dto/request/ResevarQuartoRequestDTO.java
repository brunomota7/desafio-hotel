package br.com.desafio.dto.request;

import br.com.desafio.model.Quarto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
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

    @NotBlank
    private String nomeCliente;

    @NotBlank
    private String contato;

    @NotNull
    @FutureOrPresent
    private LocalDate dataCheckIn;

    @NotNull
    @Future
    private LocalDate dataCheckOut;

    @NotNull
    @Positive
    private Integer quantPessoas;

    private Quarto quarto;

}
