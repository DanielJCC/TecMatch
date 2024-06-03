package com.tecMatch.TecMatch.service.usuario;

import com.tecMatch.TecMatch.dto.usuario.UsuarioDto;
import com.tecMatch.TecMatch.dto.usuario.UsuarioLogInDto;
import com.tecMatch.TecMatch.dto.usuario.UsuarioToSaveDto;
import com.tecMatch.TecMatch.entities.Usuario;
import com.tecMatch.TecMatch.mappers.UsuarioMapper;
import com.tecMatch.TecMatch.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UsuarioServiceImpl(UsuarioMapper usuarioMapper,UsuarioRepository usuarioRepository,
                              PasswordEncoder passwordEncoder){
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UsuarioDto save(UsuarioToSaveDto usuarioToSaveDto) {
        Usuario usuarioToSave = usuarioMapper.ToSaveDtoToEntity(usuarioToSaveDto);
        usuarioToSave.setPassword(passwordEncoder.encode(usuarioToSave.getPassword()));
        Usuario usuarioSaved = usuarioRepository.save(usuarioToSave);
        return usuarioMapper.EntityToDto(usuarioSaved);
    }

    @Override
    public UsuarioDto findById(UUID idToFind) {
        Usuario usuarioFound = usuarioRepository.findById(idToFind)
                .orElseThrow(()->new RuntimeException("Usuario no fue encontrado"));
        return usuarioMapper.EntityToDto(usuarioFound);
    }

    @Override
    public List<UsuarioDto> findAll() {
        List<Usuario> allUsuarios = usuarioRepository.findAll();
        return allUsuarios.stream().parallel().map(usuarioMapper::EntityToDto).toList();
    }

    @Override
    public UsuarioDto update(UUID idToFind, UsuarioToSaveDto usuarioToSaveDto) {
        Usuario usuarioFound = usuarioRepository.findById(idToFind)
                .orElseThrow(()->new RuntimeException("Usuario no fue encontrado"));
        usuarioFound.setCorreoElectronico(usuarioToSaveDto.correoElectronico() != null ? usuarioToSaveDto.correoElectronico() : usuarioFound.getCorreoElectronico());
        usuarioFound.setNombreUsuario(usuarioToSaveDto.nombreUsuario() != null ? usuarioToSaveDto.nombreUsuario() : usuarioFound.getNombreUsuario());
        Usuario usuarioUpdated = usuarioRepository.save(usuarioFound);
        return usuarioMapper.EntityToDto(usuarioUpdated);
    }

    @Override
    public void delete(UUID idToDelete) {
        Usuario usuarioFound = usuarioRepository.findById(idToDelete)
                .orElseThrow(()->new RuntimeException("Usuario no fue encontrado"));
        usuarioRepository.delete(usuarioFound);
    }

    @Override
    public UsuarioDto logIn(UsuarioLogInDto usuarioLogIn) {
        Usuario usuarioFound = usuarioRepository.findByNombreUsuario(usuarioLogIn.nombreUsuario())
                .orElseThrow(()->new RuntimeException("Nombre de usuario no fue encontrado"));
        if(passwordEncoder.matches(usuarioLogIn.password(),usuarioFound.getPassword())){
            return usuarioMapper.EntityToDto(usuarioFound);
        }else{
            throw new RuntimeException("Contraseña incorrecta");
        }
    }
}
