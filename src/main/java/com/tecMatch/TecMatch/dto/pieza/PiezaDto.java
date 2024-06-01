package com.tecMatch.TecMatch.dto.pieza;

import com.tecMatch.TecMatch.dto.fabricante.FabricanteDto;
import com.tecMatch.TecMatch.dto.socket.SocketDto;
import com.tecMatch.TecMatch.utils.TipoPieza;

import java.util.UUID;

public record PiezaDto(
        UUID id,
        String nombre,
        String modelo,
        Float precio,
        Float voltaje,
        String imagen,
        TipoPieza tipoPieza,
        FabricanteDto fabricante,
        SocketDto socket
) {
}
