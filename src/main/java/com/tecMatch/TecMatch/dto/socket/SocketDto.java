package com.tecMatch.TecMatch.dto.socket;

import com.tecMatch.TecMatch.dto.tipoSocket.TipoSocketDto;

import java.util.UUID;

public record SocketDto(
        UUID id,
        String nombre,
        TipoSocketDto tipoSocketDto
) {
}
