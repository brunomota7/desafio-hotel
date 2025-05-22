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
    private int numQuarto;
    private boolean resevado = false;
    private double diaria;
    private int capacidade;
    private Hotel hotel;
    private String imagemUrl;
}
