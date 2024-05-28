package com.tecMatch.TecMatch.service.tipoSocket;

import com.tecMatch.TecMatch.dto.tipoSocket.TipoSocketDto;
import com.tecMatch.TecMatch.dto.tipoSocket.TipoSocketToSaveDto;

import java.util.List;
import java.util.UUID;

public interface TipoSocketService {
    TipoSocketDto save(TipoSocketToSaveDto tipoSocketToSaveDto);
    TipoSocketDto findById(UUID idToFind);
    List<TipoSocketDto> findAll();
    TipoSocketDto update(UUID idToUpdate, TipoSocketToSaveDto tipoSocketToUpdate);
    void delete(UUID idToDelete);
    List<TipoSocketDto> findByNombreIgnoringCase(String nombre);
}
