package br.com.desafio.mapper;

import br.com.desafio.dto.response.HotelResponseDTO;
import br.com.desafio.model.Hotel;

public class HotelMapper {

    public static HotelResponseDTO toDTO(Hotel hotel) {
        var builder = HotelResponseDTO.builder()
                .id(hotel.getId())
                .nome(hotel.getNome())
                .endereco(hotel.getEndereco());

        return builder.build();
    }

}
