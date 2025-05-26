package br.com.desafio.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelRequestDTO {

    @NotBlank
    private String nome;

    @NotNull
    private String cidade;

    @NotNull
    private String endereco;
    private String imagemUrl;
}
