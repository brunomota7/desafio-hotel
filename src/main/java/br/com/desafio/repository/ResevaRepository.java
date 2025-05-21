package br.com.desafio.repository;

import br.com.desafio.model.Quarto;
import br.com.desafio.model.Reseva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResevaRepository extends JpaRepository<Reseva, Long> {
}
