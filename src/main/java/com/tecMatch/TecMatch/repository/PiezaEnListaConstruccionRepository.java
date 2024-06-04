package com.tecMatch.TecMatch.repository;

import com.tecMatch.TecMatch.entities.PiezaEnListaConstruccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PiezaEnListaConstruccionRepository extends JpaRepository<PiezaEnListaConstruccion, UUID> {
    List<PiezaEnListaConstruccion> findByUsuarioId(UUID idUsuario);
}
