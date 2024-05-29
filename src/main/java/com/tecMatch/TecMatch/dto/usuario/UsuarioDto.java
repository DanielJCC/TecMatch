package com.tecMatch.TecMatch.dto.usuario;

import java.util.UUID;

public record UsuarioDto(
        UUID id,
        String correoElectronico,
        String nombreUsuario
) {
}
