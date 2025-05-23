package br.com.desafio.repository;

import br.com.desafio.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResevaRepository extends JpaRepository<Reserva, Long> {
}
