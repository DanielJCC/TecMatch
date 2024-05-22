package com.tecMatch.TecMatch.repository;

import com.tecMatch.TecMatch.entities.Pieza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PiezaRepository extends JpaRepository<Pieza, UUID> {
    List<Pieza> findByNombreContainingIgnoreCase(String nombre);
    List<Pieza> findByModeloContainingIgnoreCase(String modelo);
    List<Pieza> findByPrecio(Float precio);
    List<Pieza> findByVoltaje(Float voltaje);
    Optional<Pieza> findByImagen(String nombre);
    List<Pieza> findByFabricanteId(UUID id);
    List<Pieza> findBySocketId(UUID id);
}
