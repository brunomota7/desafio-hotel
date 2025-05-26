package br.com.desafio.dto.request;

import br.com.desafio.model.Hotel;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuartoRequestDTO {

    @NotNull
    @Positive
    private Integer numQuarto;

    @NotNull
    @Positive
    private double diaria;

    @NotNull
    @Min(value = 1)
    private Integer capacidade;

    private boolean resevado = false;
    private String imagemUrl;

    private Hotel hotel;
}
