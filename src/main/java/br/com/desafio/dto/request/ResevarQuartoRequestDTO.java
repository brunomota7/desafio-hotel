package br.com.desafio.dto.request;

import br.com.desafio.model.Quarto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @NotNull(message = "O nome do cliente não pode ser nulo")
    private String nomeCliente;

    @NotNull(message = "O contato do cliente não pode ser nulo")
    private String contato;

    @NotBlank(message = "A data do check in é obrigatória")
    private LocalDate dataCheckIn;

    @NotBlank(message = "A data do check out é obrigatória")
    private LocalDate dataCheckOut;

    @NotBlank(message = "A quantidade de pessoas por quarto é obrigatória")
    @Pattern(regexp = "^[1-9]\\\\d*$", message = "A quantidade de pessoas deve ser um número positivo maior que zero")
    private String quantPessoas;

    private Quarto quarto;

    public Integer getQuantPessoasAsInteger() {
        return Integer.parseInt(quantPessoas);
    }
}
