package com.tecMatch.TecMatch.service.procesador;

import com.tecMatch.TecMatch.dto.procesador.ProcesadorDto;
import com.tecMatch.TecMatch.dto.procesador.ProcesadorToSaveDto;

import java.util.List;
import java.util.UUID;

public interface ProcesadorService {
    ProcesadorDto save(ProcesadorToSaveDto procesadorToSaveDto);
    List<ProcesadorDto> findAll();
    ProcesadorDto findById(UUID idToFind);
    ProcesadorDto findByPiezaId(UUID idPieza);
    ProcesadorDto update(UUID idToUpdate, ProcesadorToSaveDto procesadorToSaveDto);
    void delete(UUID idToDelete);
}
