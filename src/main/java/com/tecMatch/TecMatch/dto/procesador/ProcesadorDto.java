package com.tecMatch.TecMatch.dto.procesador;

import com.tecMatch.TecMatch.dto.pieza.PiezaDto;

import java.util.UUID;

public record ProcesadorDto(
        UUID id,
        Integer nucleos,
        Integer hilos,
        Float frecuencia,
        String cache,
        String integrado,
        PiezaDto pieza
) {
}
