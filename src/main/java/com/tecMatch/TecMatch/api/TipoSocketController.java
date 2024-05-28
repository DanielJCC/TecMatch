package com.tecMatch.TecMatch.api;

import com.tecMatch.TecMatch.dto.tipoSocket.TipoSocketDto;
import com.tecMatch.TecMatch.dto.tipoSocket.TipoSocketToSaveDto;
import com.tecMatch.TecMatch.service.tipoSocket.TipoSocketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tipos-socket")
public class TipoSocketController {
    private final TipoSocketService tipoSocketService;
    public TipoSocketController(TipoSocketService tipoSocketService){
        this.tipoSocketService = tipoSocketService;
    }
    @PostMapping()
    public ResponseEntity<TipoSocketDto> createTipoSocket(@RequestBody TipoSocketToSaveDto tipoSocketToSaveDto){
        TipoSocketDto tipoSocketSaved = tipoSocketService.save(tipoSocketToSaveDto);
        return ResponseEntity.ok().body(tipoSocketSaved);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TipoSocketDto> getTipoSocketById(@PathVariable("id") UUID id){
        try{
            TipoSocketDto tipoSockeFound = tipoSocketService.findById(id);
            return ResponseEntity.ok().body(tipoSockeFound);
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping()
    public ResponseEntity<List<TipoSocketDto>> getAllTipoSocket(){
        List<TipoSocketDto> allTipoSocket = tipoSocketService.findAll();
        return ResponseEntity.ok().body(allTipoSocket);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TipoSocketDto> updateTipoSocket(@PathVariable("id") UUID idToUpdate,@RequestBody TipoSocketToSaveDto tipoSocketToUpdate){
        try{
            TipoSocketDto tipoSocketUpdated  = tipoSocketService.update(idToUpdate,tipoSocketToUpdate);
            return ResponseEntity.ok().body(tipoSocketUpdated);
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTipoSocket(@PathVariable("id") UUID idToDelete){
        try{
            tipoSocketService.delete(idToDelete);
            return ResponseEntity.ok().body("Tipo socket con id "+idToDelete+" fue correctamente eliminado.");
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/nombre")
    public ResponseEntity<List<TipoSocketDto>> getTiposSocketByNombre(@RequestParam String contains){
        List<TipoSocketDto> tiposSocketfound = tipoSocketService.findByNombreIgnoringCase(contains);
        return ResponseEntity.ok().body(tiposSocketfound);
    }
}
