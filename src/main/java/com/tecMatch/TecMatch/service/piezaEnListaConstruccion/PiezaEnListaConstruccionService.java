package com.tecMatch.TecMatch.service.piezaEnListaConstruccion;

import com.tecMatch.TecMatch.dto.piezaDeseada.PiezaDeseadaDto;
import com.tecMatch.TecMatch.dto.piezaDeseada.PiezaDeseadaToSaveDto;
import com.tecMatch.TecMatch.dto.piezaEnListaConstruccion.PiezaEnListaConstruccionDto;
import com.tecMatch.TecMatch.dto.piezaEnListaConstruccion.PiezaEnListaConstruccionToSaveDto;

import java.util.List;
import java.util.UUID;

public interface PiezaEnListaConstruccionService {
    PiezaEnListaConstruccionDto save(PiezaEnListaConstruccionToSaveDto piezaEnListaConstruccionToSaveDto);
    List<PiezaEnListaConstruccionDto> findByUsuarioId(UUID idUsuario);
    void delete(UUID idToDelete);
}
