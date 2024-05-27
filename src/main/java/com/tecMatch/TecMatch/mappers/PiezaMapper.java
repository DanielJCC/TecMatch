package com.tecMatch.TecMatch.mappers;

import com.tecMatch.TecMatch.dto.pieza.PiezaDto;
import com.tecMatch.TecMatch.dto.pieza.PiezaToSaveDto;
import com.tecMatch.TecMatch.entities.Pieza;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PiezaMapper {
    Pieza DtoToEntity(PiezaDto piezaDto);
    PiezaDto EntityToDto(Pieza pieza);
    Pieza ToSaveDtoToEntity(PiezaToSaveDto piezaToSaveDto);
}
