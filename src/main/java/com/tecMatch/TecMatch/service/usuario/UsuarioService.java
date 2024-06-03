package com.tecMatch.TecMatch.service.usuario;

import com.tecMatch.TecMatch.dto.usuario.UsuarioDto;
import com.tecMatch.TecMatch.dto.usuario.UsuarioLogInDto;
import com.tecMatch.TecMatch.dto.usuario.UsuarioToSaveDto;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {
    UsuarioDto save(UsuarioToSaveDto usuarioToSaveDto);
    UsuarioDto findById(UUID idToFind);
    List<UsuarioDto> findAll();
    UsuarioDto update(UUID idToFind, UsuarioToSaveDto usuarioToSaveDto);
    void delete(UUID idToDelete);
    UsuarioDto logIn(UsuarioLogInDto usuarioLogIn);
}
