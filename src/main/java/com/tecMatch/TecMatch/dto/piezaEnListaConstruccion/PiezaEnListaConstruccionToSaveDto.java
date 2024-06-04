package com.tecMatch.TecMatch.dto.piezaEnListaConstruccion;

import com.tecMatch.TecMatch.dto.pieza.PiezaDto;
import com.tecMatch.TecMatch.dto.usuario.UsuarioDto;

public record PiezaEnListaConstruccionToSaveDto(
        UsuarioDto usuario,
        PiezaDto pieza
) {
}
