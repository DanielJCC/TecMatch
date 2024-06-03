package com.tecMatch.TecMatch.dto.review;

import com.tecMatch.TecMatch.dto.pieza.PiezaDto;
import com.tecMatch.TecMatch.dto.usuario.UsuarioDto;

import java.util.UUID;

public record ReviewDto(
        UUID id,
        Integer calificacion,
        String descripcion,
        UsuarioDto usuario,
        PiezaDto pieza
) {
}
