package com.tecMatch.TecMatch.service.socket;

import com.tecMatch.TecMatch.dto.socket.SocketDto;
import com.tecMatch.TecMatch.dto.socket.SocketToSaveDto;

import java.util.UUID;

public interface SocketService {
    SocketDto save(SocketToSaveDto socketToSaveDto);
    SocketDto findById(UUID idToFind);
    void deleteAll();
}
