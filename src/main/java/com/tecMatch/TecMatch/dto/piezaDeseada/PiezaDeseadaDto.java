package com.tecMatch.TecMatch.dto.piezaDeseada;

import com.tecMatch.TecMatch.dto.pieza.PiezaDto;
import com.tecMatch.TecMatch.dto.usuario.UsuarioDto;

import java.util.UUID;

public record PiezaDeseadaDto(
        UUID id,
        UsuarioDto usuario,
        PiezaDto pieza

) {
}
