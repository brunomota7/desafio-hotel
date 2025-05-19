package br.com.desafio.repository;

import br.com.desafio.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuartoRepository extends JpaRepository<Quarto, String> {
    List<Quarto> findByDisponivelTrue();
}
