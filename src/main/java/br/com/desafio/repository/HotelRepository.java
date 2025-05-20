package br.com.desafio.repository;

import br.com.desafio.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Query("SELECT h FROM Hotel h WHERE " +
            "(:nome IS NULL OR LOWER(h.nome) LIKE LOWER(CONCAT('%', :nome, '%'))) AND " +
            "(:cidade IS NULL OR h.cidade = :cidade)")
    List<Hotel> buscarPublicamente(
      @Param("nome") String nome,
      @Param("cidade") String cidade
    );
}
