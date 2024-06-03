package com.tecMatch.TecMatch.dto.review;

import com.tecMatch.TecMatch.dto.pieza.PiezaDto;
import com.tecMatch.TecMatch.dto.usuario.UsuarioDto;

public record ReviewToSaveDto(
        Integer calificacion,
        String descripcion,
        UsuarioDto usuario,
        PiezaDto pieza
) {
}
