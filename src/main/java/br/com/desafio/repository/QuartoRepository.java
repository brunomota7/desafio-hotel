package br.com.desafio.repository;

import br.com.desafio.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuartoRepository extends JpaRepository<Quarto, Long> {
    Quarto findByNumQuarto(int numQuarto);
    List<Quarto> findByResevadoFalse();
    List<Quarto> findByResevadoTrue();
    @Query("SELECT q FROM Quarto q WHERE LOWER(q.hotel.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Quarto> findByHotel(@Param("nome") String nome);

}
