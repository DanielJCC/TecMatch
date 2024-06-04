package com.tecMatch.TecMatch.dto.piezaDeseada;

import com.tecMatch.TecMatch.dto.pieza.PiezaDto;
import com.tecMatch.TecMatch.dto.usuario.UsuarioDto;

public record PiezaDeseadaToSaveDto(
        UsuarioDto usuario,
        PiezaDto pieza
) {
}
