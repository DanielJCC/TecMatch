package com.tecMatch.TecMatch.repository;

import com.tecMatch.TecMatch.entities.Grafica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GraficaRepository extends JpaRepository<Grafica, UUID> {
    Optional<Grafica> findByPiezaId(UUID idPieza);
}
