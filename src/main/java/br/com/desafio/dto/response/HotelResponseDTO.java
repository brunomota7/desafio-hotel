package br.com.desafio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelResponseDTO {
    private Long id;
    private String nome;
    private String cidade;
    private String endereco;
    private String imagemUrl;
}
