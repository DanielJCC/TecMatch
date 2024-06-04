package com.tecMatch.TecMatch.mappers;

import com.tecMatch.TecMatch.dto.grafica.GraficaDto;
import com.tecMatch.TecMatch.dto.grafica.GraficaToSaveDto;
import com.tecMatch.TecMatch.entities.Grafica;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface GraficaMapper {
    Grafica DtoToEntity(GraficaDto graficaDto);
    GraficaDto EntityToDto(Grafica grafica);
    Grafica ToSaveDtoToEntity(GraficaToSaveDto graficaToSaveDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "pieza", ignore = true)
    void updateGraficaFromToSaveDto(GraficaToSaveDto graficaToSaveDto, @MappingTarget Grafica grafica);
}
