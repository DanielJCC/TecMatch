package com.tecMatch.TecMatch.dto.piezaEnListaConstruccion;

import com.tecMatch.TecMatch.dto.pieza.PiezaDto;
import com.tecMatch.TecMatch.dto.usuario.UsuarioDto;

import java.util.UUID;

public record PiezaEnListaConstruccionDto(
        UUID id,
        UsuarioDto usuario,
        PiezaDto pieza

) {
}
