package com.tecMatch.TecMatch.mappers;

import com.tecMatch.TecMatch.dto.ram.RamDto;
import com.tecMatch.TecMatch.dto.ram.RamToSaveDto;
import com.tecMatch.TecMatch.entities.Ram;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RamMapper {
    Ram DtoToEntity(RamDto ramDto);
    RamDto EntityToDto(Ram ram);
    Ram ToSaveDtoToEntity(RamToSaveDto ramToSaveDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "pieza", ignore = true)
    void updateRamFromToSaveDto(RamToSaveDto ramToSaveDto, @MappingTarget Ram ram);
}
