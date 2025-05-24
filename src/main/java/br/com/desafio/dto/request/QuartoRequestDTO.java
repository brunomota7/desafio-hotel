package br.com.desafio.dto.request;

import br.com.desafio.model.Hotel;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuartoRequestDTO {

    @NotBlank(message = "O número do quarto é obrigatório")
    @Pattern(regexp = "\\d+", message = "O número do quarto deve conter apenas dígitos")
    private String numQuarto;

    @NotBlank(message = "O valor da diária do quarto é obrigatória")
    @Positive(message = "O valor da diária tem que ser positivo")
    private double diaria;

    @NotBlank(message = "A capacidade do quarto é obrigatória.")
    @Min(value = 1, message = "A capacidade não pode ser negativa")
    private int capacidade;

    private boolean resevado = false;
    private String imagemUrl;

    private Hotel hotel;

    public Integer getNumQuartoAsInteger() {
        return Integer.parseInt(numQuarto);
    }
}
