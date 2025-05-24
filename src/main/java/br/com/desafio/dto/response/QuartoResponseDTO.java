package br.com.desafio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuartoResponseDTO {
    private Long id;
    private int numQuarto;
    private boolean resevado;
    private double diaria;
    private int capacidade;
    private String imagemUrl;
    private HotelInfoDTO hotel;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HotelInfoDTO {
        private Long id;
        private String nome;
    }
}
