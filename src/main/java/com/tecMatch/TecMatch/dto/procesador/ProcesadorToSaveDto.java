package com.tecMatch.TecMatch.dto.procesador;

import com.tecMatch.TecMatch.dto.pieza.PiezaDto;

public record ProcesadorToSaveDto(
        Integer nucleos,
        Integer hilos,
        Float frecuencia,
        String cache,
        String integrado,
        PiezaDto pieza
) {
}
