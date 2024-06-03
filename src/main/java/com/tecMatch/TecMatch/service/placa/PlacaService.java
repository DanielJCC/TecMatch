package com.tecMatch.TecMatch.service.placa;

import com.tecMatch.TecMatch.dto.placa.PlacaDto;
import com.tecMatch.TecMatch.dto.placa.PlacaToSaveDto;

import java.util.List;
import java.util.UUID;

public interface PlacaService {
    PlacaDto save(PlacaToSaveDto placaToSaveDto);
    List<PlacaDto> findAll();
    PlacaDto findById(UUID idToFind);
    PlacaDto findByPiezaId(UUID idPieza);
    PlacaDto update(UUID idToUpdate, PlacaToSaveDto placaToSaveDto);
    void delete(UUID idToDelete);
}
