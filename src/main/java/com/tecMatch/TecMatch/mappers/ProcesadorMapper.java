package com.tecMatch.TecMatch.mappers;

import com.tecMatch.TecMatch.dto.procesador.ProcesadorDto;
import com.tecMatch.TecMatch.dto.procesador.ProcesadorToSaveDto;
import com.tecMatch.TecMatch.entities.Procesador;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProcesadorMapper {
    Procesador DtoToEntity(ProcesadorDto procesadorDto);
    ProcesadorDto EntityToDto(Procesador procesador);
    Procesador ToSaveDtoToEntity(ProcesadorToSaveDto procesadorToSaveDto);
}
