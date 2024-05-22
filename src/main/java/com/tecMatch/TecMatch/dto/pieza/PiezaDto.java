package com.tecMatch.TecMatch.dto.pieza;

import com.tecMatch.TecMatch.dto.fabricante.FabricanteDto;
import com.tecMatch.TecMatch.dto.socket.SocketDto;

import java.util.UUID;

public record PiezaDto(
        UUID id,
        String nombre,
        String modelo,
        Float precio,
        Float voltaje,
        String imagen,
        FabricanteDto fabricanteDto,
        SocketDto socketDto
) {
}
