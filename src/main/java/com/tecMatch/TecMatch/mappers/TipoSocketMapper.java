package com.tecMatch.TecMatch.mappers;

import com.tecMatch.TecMatch.dto.tipoSocket.TipoSocketDto;
import com.tecMatch.TecMatch.dto.tipoSocket.TipoSocketToSaveDto;
import com.tecMatch.TecMatch.entities.TipoSocket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TipoSocketMapper {
    TipoSocket DtoToEntity(TipoSocketDto tipoSocketDto);
    TipoSocketDto EntityToDto(TipoSocket tipoSocket);
    TipoSocket ToSaveDtoToEntity(TipoSocketToSaveDto tipoSocketToSaveDto);
}
