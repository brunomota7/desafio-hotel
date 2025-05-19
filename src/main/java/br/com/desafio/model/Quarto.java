package br.com.desafio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_quarto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String codgQuarto;

    @Column(nullable = false)
    private boolean resevado;

    @Column(nullable = false)
    private double diaria;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    private String imagemUrl;

}
