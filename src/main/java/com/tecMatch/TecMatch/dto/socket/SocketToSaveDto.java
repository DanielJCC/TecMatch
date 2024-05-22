package com.tecMatch.TecMatch.dto.socket;

import com.tecMatch.TecMatch.dto.tipoSocket.TipoSocketDto;

public record SocketToSaveDto(
        String nombre,
        TipoSocketDto tipoSocketDto
) {
}
