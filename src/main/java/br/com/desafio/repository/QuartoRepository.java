package br.com.desafio.repository;

import br.com.desafio.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuartoRepository extends JpaRepository<Quarto, String> {
    List<Quarto> findByResevadoFalse();
//    @Query("SELECT q FROM Quarto q WHERE " +
//           "(:hotel IS NULL OR LOWER(q.nome) LIKE LOWER(CONCAT('%', :hotel, '%')))")
//    List<Quarto> findByHotel(
//            @Param("hotel") String hotel);
}
