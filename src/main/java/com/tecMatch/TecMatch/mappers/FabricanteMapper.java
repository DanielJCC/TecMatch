package com.tecMatch.TecMatch.mappers;

import com.tecMatch.TecMatch.dto.fabricante.FabricanteDto;
import com.tecMatch.TecMatch.dto.fabricante.FabricanteToSaveDto;
import com.tecMatch.TecMatch.entities.Fabricante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface FabricanteMapper {
    Fabricante DtoToEntity(FabricanteDto fabricanteDto);
    FabricanteDto EntityToDto(Fabricante fabricante);
    @Mapping(target = "id",ignore = true)
    Fabricante ToSaveDtoToEntity(FabricanteToSaveDto fabricanteToSaveDto);
}
