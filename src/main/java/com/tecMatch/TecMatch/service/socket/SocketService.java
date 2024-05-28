package com.tecMatch.TecMatch.service.socket;

import com.tecMatch.TecMatch.dto.socket.SocketDto;
import com.tecMatch.TecMatch.dto.socket.SocketToSaveDto;

import java.util.List;
import java.util.UUID;

public interface SocketService {
    SocketDto save(SocketToSaveDto socketToSaveDto);
    SocketDto findById(UUID idToFind);
    List<SocketDto> findAll();
    SocketDto update(UUID idToUpdate, SocketToSaveDto socketToUpdate);
    void delete(UUID idToDelete);
    List<SocketDto> findByNombreIgnoringCase(String nombre);
    List<SocketDto> findByTipoSocketId(UUID tipoSocketId);
}
