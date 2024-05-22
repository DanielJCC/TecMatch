package com.tecMatch.TecMatch.service.tipoSocket;

import com.tecMatch.TecMatch.dto.tipoSocket.TipoSocketDto;
import com.tecMatch.TecMatch.dto.tipoSocket.TipoSocketToSaveDto;

import java.util.UUID;

public interface TipoSocketService {
    TipoSocketDto save(TipoSocketToSaveDto tipoSocketToSaveDto);
    TipoSocketDto findById(UUID idToFind);
}
