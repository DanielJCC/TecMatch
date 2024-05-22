package com.tecMatch.TecMatch.service.fabricante;

import com.tecMatch.TecMatch.dto.fabricante.FabricanteDto;
import com.tecMatch.TecMatch.dto.fabricante.FabricanteToSaveDto;

import java.util.UUID;

public interface FabricanteService {
    FabricanteDto save(FabricanteToSaveDto fabricanteToSaveDto);
    FabricanteDto findById(UUID idToFind);
}
