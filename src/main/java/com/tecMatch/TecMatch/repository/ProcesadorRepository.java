package com.tecMatch.TecMatch.repository;

import com.tecMatch.TecMatch.entities.Procesador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProcesadorRepository extends JpaRepository<Procesador, UUID> {
    Optional<Procesador> findByPiezaId(UUID idPieza);
}
