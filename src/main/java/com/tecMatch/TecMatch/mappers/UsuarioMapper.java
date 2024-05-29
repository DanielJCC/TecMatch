package com.tecMatch.TecMatch.mappers;

import com.tecMatch.TecMatch.dto.usuario.UsuarioDto;
import com.tecMatch.TecMatch.dto.usuario.UsuarioToSaveDto;
import com.tecMatch.TecMatch.entities.Usuario;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario DtoToEntity(UsuarioDto usuarioDto);
    UsuarioDto EntityToDto(Usuario usuario);
    Usuario ToSaveDtoToEntity(UsuarioToSaveDto usuarioToSaveDto);
}
