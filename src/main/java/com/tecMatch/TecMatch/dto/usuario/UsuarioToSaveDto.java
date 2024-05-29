package com.tecMatch.TecMatch.dto.usuario;

public record UsuarioToSaveDto(
        String correoElectronico,
        String password,
        String nombreUsuario,
        Boolean perm_admin
) {
}
