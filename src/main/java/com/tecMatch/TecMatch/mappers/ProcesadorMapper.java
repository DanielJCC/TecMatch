package com.tecMatch.TecMatch.mappers;

import com.tecMatch.TecMatch.dto.procesador.ProcesadorDto;
import com.tecMatch.TecMatch.dto.procesador.ProcesadorToSaveDto;
import com.tecMatch.TecMatch.entities.Procesador;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProcesadorMapper {
    Procesador DtoToEntity(ProcesadorDto procesadorDto);
    ProcesadorDto EntityToDto(Procesador procesador);
    Procesador ToSaveDtoToEntity(ProcesadorToSaveDto procesadorToSaveDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "pieza", ignore = true)
    void updateProcesadorFromToSaveDto(ProcesadorToSaveDto procesadorToSaveDto, @MappingTarget Procesador procesador);
}
