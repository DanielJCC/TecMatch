package com.tecMatch.TecMatch.mappers;

import com.tecMatch.TecMatch.dto.piezaDeseada.PiezaDeseadaDto;
import com.tecMatch.TecMatch.dto.piezaDeseada.PiezaDeseadaToSaveDto;
import com.tecMatch.TecMatch.entities.PiezaDeseada;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PiezaDeseadaMapper {
    PiezaDeseada DtoToEntity(PiezaDeseadaDto piezaDeseadaDto);
    PiezaDeseadaDto EntityToDto(PiezaDeseada piezaDeseada);
    PiezaDeseada ToSaveDtoToEntity(PiezaDeseadaToSaveDto piezaDeseadaToSaveDto);
}
