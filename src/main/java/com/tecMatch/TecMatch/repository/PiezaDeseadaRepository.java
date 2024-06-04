package com.tecMatch.TecMatch.repository;

import com.tecMatch.TecMatch.entities.PiezaDeseada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PiezaDeseadaRepository extends JpaRepository<PiezaDeseada, UUID> {
    List<PiezaDeseada> findByUsuarioId(UUID idUsuario);
}
