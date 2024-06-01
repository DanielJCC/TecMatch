package com.tecMatch.TecMatch.repository;

import com.tecMatch.TecMatch.entities.Ram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RamRepository extends JpaRepository<Ram, UUID>{
    Optional<Ram> findByPiezaId(UUID idPieza);
}
