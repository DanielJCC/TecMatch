package com.tecMatch.TecMatch.repository;

import com.tecMatch.TecMatch.entities.Socket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SocketRepository extends JpaRepository<Socket, UUID> {
    List<Socket> findByNombreContainingIgnoreCase(String nombre);
    List<Socket> findByTipoSocketId(UUID idTipoSocket);
}
