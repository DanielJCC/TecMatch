package com.tecMatch.TecMatch.service.socket;

import com.tecMatch.TecMatch.dto.socket.SocketDto;
import com.tecMatch.TecMatch.dto.socket.SocketToSaveDto;
import com.tecMatch.TecMatch.entities.Socket;
import com.tecMatch.TecMatch.entities.TipoSocket;
import com.tecMatch.TecMatch.mappers.SocketMapper;
import com.tecMatch.TecMatch.repository.SocketRepository;
import com.tecMatch.TecMatch.repository.TipoSocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class SocketServiceImpl implements SocketService{
    private final SocketRepository socketRepository;
    private final SocketMapper socketMapper;
    private final TipoSocketRepository tipoSocketRepository;
    @Autowired
    public SocketServiceImpl(SocketRepository socketRepository,
                             SocketMapper socketMapper,
                             TipoSocketRepository tipoSocketRepository){
        this.socketRepository = socketRepository;
        this.socketMapper = socketMapper;
        this.tipoSocketRepository = tipoSocketRepository;
    }
    @Override
    public SocketDto save(SocketToSaveDto socketToSaveDto) {
        TipoSocket tipoSocketFound = tipoSocketRepository.findById(socketToSaveDto.tipoSocketDto().id())
                .orElseThrow(()->new RuntimeException("Tipo de socket no encontrado"));
        Socket socketToSave = socketMapper.ToSaveDtoToEntity(socketToSaveDto);
        socketToSave.setTipoSocket(tipoSocketFound);
        Socket socketSaved = socketRepository.save(socketToSave);
        return socketMapper.EntityToDto(socketSaved);
    }

    @Override
    public SocketDto findById(UUID idToFind) {
        Socket socketFound = socketRepository.findById(idToFind)
                .orElseThrow(()->new RuntimeException("Socket no encontrado"));
        return socketMapper.EntityToDto(socketFound);
    }
}
