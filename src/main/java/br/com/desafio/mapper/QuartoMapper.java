package br.com.desafio.mapper;

import br.com.desafio.dto.response.QuartoResponseDTO;
import br.com.desafio.model.Quarto;

public class QuartoMapper {

    public static QuartoResponseDTO toDTO(Quarto quarto) {
        var builder = QuartoResponseDTO.builder()
                .codgQuarto(quarto.getCodgQuarto())
                .resevado(quarto.isResevado())
                .diaria(quarto.getDiaria())
                .imagemUrl(quarto.getImagemUrl())
                .hotel(QuartoResponseDTO.HotelInfoDTO.builder()
                        .id(quarto.getHotel().getId())
                        .nome(quarto.getHotel().getNome())
                        .build()
                );

        return builder.build();
    }

}
