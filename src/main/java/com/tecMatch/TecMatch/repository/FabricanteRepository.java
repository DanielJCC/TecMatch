package com.tecMatch.TecMatch.repository;

import com.tecMatch.TecMatch.entities.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FabricanteRepository extends JpaRepository<Fabricante,UUID> {
    List<Fabricante> findByNombreContainingIgnoreCase(String nombre);
}
