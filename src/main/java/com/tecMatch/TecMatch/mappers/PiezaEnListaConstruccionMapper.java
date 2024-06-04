package com.tecMatch.TecMatch.mappers;

import com.tecMatch.TecMatch.dto.piezaEnListaConstruccion.PiezaEnListaConstruccionDto;
import com.tecMatch.TecMatch.dto.piezaEnListaConstruccion.PiezaEnListaConstruccionToSaveDto;
import com.tecMatch.TecMatch.entities.PiezaEnListaConstruccion;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PiezaEnListaConstruccionMapper {
    PiezaEnListaConstruccionDto EntityToDto(PiezaEnListaConstruccion piezaEnListaConstruccion);
    PiezaEnListaConstruccion DtoToEntity(PiezaEnListaConstruccionDto piezaEnListaConstruccionDto);
    PiezaEnListaConstruccion ToSaveDtoToEntity(PiezaEnListaConstruccionToSaveDto piezaEnListaConstruccionToSaveDto);
}
