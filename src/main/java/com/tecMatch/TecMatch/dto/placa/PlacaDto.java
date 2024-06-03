package com.tecMatch.TecMatch.dto.placa;

import com.tecMatch.TecMatch.dto.pieza.PiezaDto;

import java.util.UUID;

public record PlacaDto(
        UUID id,
        Integer cantidadDIMMs,
        Integer alimentacion,
        Integer EPS,
        Integer puertosVentilador,
        Boolean pump,
        Boolean PCLe_M2,
        Integer puertosSATA,
        Integer cantidadUSBTipo3,
        Integer cantidadUSBTipo2,
        Integer cantidadUSBC,
        Integer cantidadHDAudio,
        Integer cantidadHDMI,
        PiezaDto pieza
) {
}
