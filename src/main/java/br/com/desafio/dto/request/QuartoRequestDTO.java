package br.com.desafio.dto.request;

import br.com.desafio.model.Hotel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuartoRequestDTO {
    private boolean resevado = false;
    private double diaria;
    private Hotel hotel;
    private String imagemUrl;
}
