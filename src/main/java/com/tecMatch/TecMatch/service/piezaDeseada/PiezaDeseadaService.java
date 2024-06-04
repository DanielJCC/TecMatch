package com.tecMatch.TecMatch.service.piezaDeseada;

import com.tecMatch.TecMatch.dto.piezaDeseada.PiezaDeseadaDto;
import com.tecMatch.TecMatch.dto.piezaDeseada.PiezaDeseadaToSaveDto;

import java.util.List;
import java.util.UUID;

public interface PiezaDeseadaService {
    PiezaDeseadaDto save(PiezaDeseadaToSaveDto piezaDeseadaToSaveDto);
    List<PiezaDeseadaDto> findByUsuarioId(UUID idUsuario);
    void delete(UUID idToDelete);
}
