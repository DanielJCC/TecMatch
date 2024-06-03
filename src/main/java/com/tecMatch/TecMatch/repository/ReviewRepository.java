package com.tecMatch.TecMatch.repository;

import com.tecMatch.TecMatch.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {
    @Query("SELECT AVG(r.calificacion) FROM Review r WHERE r.pieza.id = ?1")
    Optional<Double> getPromedioCalificacionesByPiezaId(UUID idPieza);
    List<Review> findByPiezaId(UUID idPieza);
}
