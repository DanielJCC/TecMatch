package com.tecMatch.TecMatch.service.tipoSocket;

import com.tecMatch.TecMatch.dto.tipoSocket.TipoSocketDto;
import com.tecMatch.TecMatch.dto.tipoSocket.TipoSocketToSaveDto;
import com.tecMatch.TecMatch.entities.TipoSocket;
import com.tecMatch.TecMatch.mappers.TipoSocketMapper;
import com.tecMatch.TecMatch.repository.TipoSocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TipoSocketServiceImpl implements TipoSocketService{
    private final TipoSocketMapper tipoSocketMapper;
    private final TipoSocketRepository tipoSocketRepository;
    @Autowired
    public TipoSocketServiceImpl(TipoSocketMapper tipoSocketMapper,
                                 TipoSocketRepository tipoSocketRepository){
        this.tipoSocketMapper = tipoSocketMapper;
        this.tipoSocketRepository = tipoSocketRepository;
    }
    @Override
    public TipoSocketDto save(TipoSocketToSaveDto tipoSocketToSaveDto) {
        TipoSocket tipoSocketToSave = tipoSocketMapper.ToSaveDtoToEntity(tipoSocketToSaveDto);
        TipoSocket tipoSocketSaved = tipoSocketRepository.save(tipoSocketToSave);
        return tipoSocketMapper.EntityToDto(tipoSocketSaved);
    }

    @Override
    public TipoSocketDto findById(UUID idToFind) {
        TipoSocket tipoSocketFound = tipoSocketRepository.findById(idToFind)
                .orElseThrow(()->new RuntimeException("Tipo de Socket no encontrado"));
        return tipoSocketMapper.EntityToDto(tipoSocketFound);
    }
}
