package br.com.desafio.mapper;

import br.com.desafio.dto.response.ReservaResponseDTO;
import br.com.desafio.model.Hotel;
import br.com.desafio.model.Quarto;
import br.com.desafio.model.Reserva;

public class ReservaMapper {

    public static ReservaResponseDTO toDTO(Reserva reserva) {
        Quarto quarto = reserva.getQuarto();
        Hotel hotel = quarto.getHotel();

        return ReservaResponseDTO.builder()
                .id(reserva.getId())
                .nomeCliente(reserva.getNomeCliente())
                .contato(reserva.getContato())
                .dataCheckIn(reserva.getDataCheckIn())
                .dataCheckOut(reserva.getDataCheckOut())
                .quantPessoas(reserva.getQuantPessoas())
                .quarto(ReservaResponseDTO.QuartoInfoDTO.builder()
                        .numQuarto(quarto.getNumQuarto())
                        .resevado(quarto.isResevado())
                        .hotel(ReservaResponseDTO.HotelInfoDTO.builder()
                                .nome(hotel.getNome())
                                .cidade(hotel.getCidade())
                                .endereco(hotel.getEndereco())
                                .build())
                        .build())
                .build();
    }
}
