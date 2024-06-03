package com.tecMatch.TecMatch.api;

import com.tecMatch.TecMatch.dto.usuario.UsuarioDto;
import com.tecMatch.TecMatch.dto.usuario.UsuarioLogInDto;
import com.tecMatch.TecMatch.dto.usuario.UsuarioToSaveDto;
import com.tecMatch.TecMatch.service.usuario.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    @PostMapping()
    public ResponseEntity<UsuarioDto> createUsuario(@RequestBody UsuarioToSaveDto usuarioToSaveDto){
        UsuarioDto usuarioSaved = usuarioService.save(usuarioToSaveDto);
        return ResponseEntity.ok().body(usuarioSaved);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> findUsuariosById(@PathVariable UUID id){
        try{
            UsuarioDto usuarioFound = usuarioService.findById(id);
            return ResponseEntity.ok().body(usuarioFound);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping()
    public ResponseEntity<List<UsuarioDto>> findAllUsuarios(){
        List<UsuarioDto> allUsuarios = usuarioService.findAll();
        return ResponseEntity.ok().body(allUsuarios);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> updateUsuario(@PathVariable UUID id, @RequestBody UsuarioToSaveDto usuarioToUpdate){
        try{
            UsuarioDto usuarioUpdated = usuarioService.update(id,usuarioToUpdate);
            return ResponseEntity.ok().body(usuarioUpdated);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable UUID id){
        try{
            usuarioService.delete(id);
            return ResponseEntity.ok().body("Usuario eliminado correctamente");
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/login")
    public ResponseEntity<UsuarioDto> logInUsuario(@RequestBody UsuarioLogInDto usuarioLogInDto){
        try {
            UsuarioDto usuarioLogged = usuarioService.logIn(usuarioLogInDto);
            return ResponseEntity.ok().body(usuarioLogged);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
