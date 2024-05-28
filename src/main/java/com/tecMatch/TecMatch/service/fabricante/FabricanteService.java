package com.tecMatch.TecMatch.service.fabricante;

import com.tecMatch.TecMatch.dto.fabricante.FabricanteDto;
import com.tecMatch.TecMatch.dto.fabricante.FabricanteToSaveDto;

import java.util.List;
import java.util.UUID;

public interface FabricanteService {
    FabricanteDto save(FabricanteToSaveDto fabricanteToSaveDto);
    FabricanteDto findById(UUID idToFind);
    List<FabricanteDto> findAll();
    FabricanteDto update(UUID idToUpdate, FabricanteToSaveDto fabricanteToUpdate);
    void delete(UUID idToDelete);
    List<FabricanteDto> findByNombreContainingIgnoreCase(String nombre);
}
