package com.tecMatch.TecMatch.service.pieza;

import com.tecMatch.TecMatch.dto.pieza.PiezaDto;
import com.tecMatch.TecMatch.dto.pieza.PiezaToSaveDto;

import java.util.List;
import java.util.UUID;

public interface PiezaService {
    PiezaDto save(PiezaToSaveDto piezaToSaveDto);
    PiezaDto findById(UUID idToFind);
    List<PiezaDto> findAll();
}
