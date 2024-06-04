package com.tecMatch.TecMatch.mappers;

import com.tecMatch.TecMatch.dto.placa.PlacaDto;
import com.tecMatch.TecMatch.dto.placa.PlacaToSaveDto;
import com.tecMatch.TecMatch.entities.Placa;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PlacaMapper {
    Placa DtoToEntity(PlacaDto placaDto);
    PlacaDto EntityToDto(Placa placa);
    Placa ToSaveDtoToEntity(PlacaToSaveDto placaToSaveDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "pieza", ignore = true)
    void updatePlacaFromToSaveDto(PlacaToSaveDto placaToSaveDto, @MappingTarget Placa placa);
}
