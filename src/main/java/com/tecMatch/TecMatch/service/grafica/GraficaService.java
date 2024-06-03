package com.tecMatch.TecMatch.service.grafica;

import com.tecMatch.TecMatch.dto.grafica.GraficaDto;
import com.tecMatch.TecMatch.dto.grafica.GraficaToSaveDto;

import java.util.List;
import java.util.UUID;

public interface GraficaService {
    GraficaDto save(GraficaToSaveDto graficaToSaveDto);
    List<GraficaDto> findAll();
    GraficaDto findById(UUID idToFind);
    GraficaDto findByPiezaId(UUID idPieza);
    GraficaDto update(UUID idToUpdate, GraficaToSaveDto graficaToSaveDto);
    void delete(UUID idToDelete);
}
