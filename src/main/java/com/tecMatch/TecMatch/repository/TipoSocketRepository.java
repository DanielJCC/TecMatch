package com.tecMatch.TecMatch.repository;

import com.tecMatch.TecMatch.entities.TipoSocket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TipoSocketRepository extends JpaRepository<TipoSocket, UUID> {
    List<TipoSocket> findByNombreContainingIgnoreCase(String nombre);
}
