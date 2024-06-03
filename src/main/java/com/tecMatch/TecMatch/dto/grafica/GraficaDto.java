package com.tecMatch.TecMatch.dto.grafica;

import com.tecMatch.TecMatch.dto.pieza.PiezaDto;

import java.util.UUID;

public record GraficaDto(
        UUID id,
        Integer nucleos,
        Float frecuencia,
        Integer memoria,
        String interfaz_memoria,
        Integer ancho_banda,
        Integer ventiladores,
        Integer cant_HDMI,
        Integer cant_DisplayPorts,
        PiezaDto pieza
) {
}
