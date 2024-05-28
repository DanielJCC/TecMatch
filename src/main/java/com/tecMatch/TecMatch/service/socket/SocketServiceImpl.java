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

import java.util.List;
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
        TipoSocket tipoSocketFound = tipoSocketRepository.findById(socketToSaveDto.tipoSocket().id())
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

    @Override
    public List<SocketDto> findAll() {
        List<Socket> allSockets = socketRepository.findAll();
        return allSockets.stream().parallel().map(socketMapper::EntityToDto).toList();
    }

    @Override
    public SocketDto update(UUID idToUpdate, SocketToSaveDto socketToUpdate) {
        Socket socketFound = socketRepository.findById(idToUpdate)
                .orElseThrow(()->new RuntimeException("Socket no encontrado"));
        socketFound.setNombre(socketToUpdate.nombre() != null ? socketToUpdate.nombre() : socketFound.getNombre());
        Socket socketUpdated = socketRepository.save(socketFound);
        return socketMapper.EntityToDto(socketUpdated);
    }

    @Override
    public void delete(UUID idToDelete) {
        Socket socketFound = socketRepository.findById(idToDelete)
                .orElseThrow(()->new RuntimeException("Socket no encontrado"));
        socketRepository.delete(socketFound);
    }

    @Override
    public List<SocketDto> findByNombreIgnoringCase(String nombre) {
        List<Socket> socketsFound = socketRepository.findByNombreContainingIgnoreCase(nombre);
        return socketsFound.stream().parallel().map(socketMapper::EntityToDto).toList();
    }

    @Override
    public List<SocketDto> findByTipoSocketId(UUID tipoSocketId) {
        List<Socket> socketsFound = socketRepository.findByTipoSocketId(tipoSocketId);
        return socketsFound.stream().parallel().map(socketMapper::EntityToDto).toList();
    }
}
