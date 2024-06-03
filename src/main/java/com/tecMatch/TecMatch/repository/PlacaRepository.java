package com.tecMatch.TecMatch.repository;

import com.tecMatch.TecMatch.entities.Placa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlacaRepository extends JpaRepository<Placa, UUID> {
    Optional<Placa> findByPiezaId(UUID idPieza);
}
