package br.com.desafio.mapper;

import br.com.desafio.dto.response.ResevaResponseDTO;
import br.com.desafio.model.Hotel;
import br.com.desafio.model.Quarto;
import br.com.desafio.model.Reseva;

public class ResevaMapper {

    public static ResevaResponseDTO toDTO(Reseva reseva) {
        Quarto quarto = reseva.getQuarto();
        Hotel hotel = quarto.getHotel();

        return ResevaResponseDTO.builder()
                .id(reseva.getId())
                .nomeCliente(reseva.getNomeCliente())
                .dataCheckIn(reseva.getDataCheckIn())
                .dataCheckOut(reseva.getDataCheckOut())
                .quarto(ResevaResponseDTO.QuartoInfoDTO.builder()
                        .codgQuarto(quarto.getCodgQuarto())
                        .resevado(quarto.isResevado())
                        .hotel(ResevaResponseDTO.HotelInfoDTO.builder()
                                .nome(hotel.getNome())
                                .cidade(hotel.getCidade())
                                .endereco(hotel.getEndereco())
                                .build())
                        .build())
                .build();
    }
}
