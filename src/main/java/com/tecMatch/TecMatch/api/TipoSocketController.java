package com.tecMatch.TecMatch.api;

import com.tecMatch.TecMatch.dto.tipoSocket.TipoSocketDto;
import com.tecMatch.TecMatch.dto.tipoSocket.TipoSocketToSaveDto;
import com.tecMatch.TecMatch.service.tipoSocket.TipoSocketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
