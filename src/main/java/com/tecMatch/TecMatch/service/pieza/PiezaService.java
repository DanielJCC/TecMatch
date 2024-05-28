package com.tecMatch.TecMatch.service.pieza;

import com.tecMatch.TecMatch.dto.pieza.PiezaDto;
import com.tecMatch.TecMatch.dto.pieza.PiezaToSaveDto;

import java.util.List;
import java.util.UUID;

public interface PiezaService {
    PiezaDto save(PiezaToSaveDto piezaToSaveDto);
    PiezaDto findById(UUID idToFind);
    List<PiezaDto> findAll();
    PiezaDto update(UUID idToUpdate, PiezaToSaveDto piezaToUpdate);
    void deleteById(UUID idToDelete);
    List<PiezaDto> findByNombreIgnoringCase(String nombre);
    List<PiezaDto> findByModeloIgnoringCase(String modelo);
    List<PiezaDto> findByPrecioMenorQue(Float precio);
    List<PiezaDto> findByVoltaje(Float voltaje);
    List<PiezaDto> findByFabricanteId(UUID id);
    List<PiezaDto> findBySocketId(UUID id);
}
