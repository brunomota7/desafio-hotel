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

    @NotBlank(message = "O nome do hotel é obrigatório")
    private String nome;

    @NotNull(message = "O nome da cidade não pode ser nulo")
    private String cidade;

    @NotNull(message = "O endereço do hotel não pode ser nulo")
    private String endereco;
    private String imagemUrl;
}
