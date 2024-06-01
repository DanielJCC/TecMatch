package com.tecMatch.TecMatch.service.ram;

import com.tecMatch.TecMatch.dto.ram.RamDto;
import com.tecMatch.TecMatch.dto.ram.RamToSaveDto;

import java.util.List;
import java.util.UUID;

public interface RamService {
    RamDto save(RamToSaveDto ramToSaveDto);
    RamDto findById(UUID idToFind);
    List<RamDto> findAll();
    RamDto update(UUID idToUpdate, RamToSaveDto ramToUpdateDto);
    void delete(UUID idToDelete);
    RamDto findByPiezaId(UUID idPieza);
}
