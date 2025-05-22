package br.com.desafio.mapper;

import br.com.desafio.dto.response.HotelResponseDTO;
import br.com.desafio.model.Hotel;

public class HotelMapper {

    public static HotelResponseDTO toDTO(Hotel hotel) {
        var builder = HotelResponseDTO.builder()
                .id(hotel.getId())
                .nome(hotel.getNome())
                .cidade(hotel.getCidade())
                .endereco(hotel.getEndereco())
                .imagemUrl(hotel.getImagemUrl());

        return builder.build();
    }

}
