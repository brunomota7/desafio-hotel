package br.com.desafio.dto.response;

import br.com.desafio.model.Quarto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResevaResponseDTO {
    private Long id;
    private String nomeCliente;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private QuartoInfoDTO quarto;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuartoInfoDTO {
        private String codgQuarto;
        private boolean resevado;
        private HotelInfoDTO hotel;

    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HotelInfoDTO {
        private String nome;
        private String cidade;
        private String endereco;
    }

}
