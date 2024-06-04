package com.tecMatch.TecMatch.api;

import com.tecMatch.TecMatch.dto.placa.PlacaDto;
import com.tecMatch.TecMatch.dto.placa.PlacaToSaveDto;
import com.tecMatch.TecMatch.service.placa.PlacaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/PLACA")
public class PlacaController {
    private final PlacaService placaService;

    public PlacaController(PlacaService placaService){
        this.placaService = placaService;
    }

    @PostMapping()
    public ResponseEntity<PlacaDto> createPlaca(@RequestBody PlacaToSaveDto placaToSaveDto){
        PlacaDto placaSaved = placaService.save(placaToSaveDto);
        return ResponseEntity.ok().body(placaSaved);
    }

    @GetMapping()
    public ResponseEntity<List<PlacaDto>> findAllPlacas(){
        List<PlacaDto> allPlacas = placaService.findAll();
        return ResponseEntity.ok().body(allPlacas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlacaDto> findPlacaById(@PathVariable UUID id){
        try{
            PlacaDto placaFound = placaService.findById(id);
            return ResponseEntity.ok().body(placaFound);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/pieza/{id}")
    public ResponseEntity<PlacaDto> findPlacaByPiezaId(@PathVariable UUID id){
        try{
            PlacaDto placaFound = placaService.findByPiezaId(id);
            return ResponseEntity.ok().body(placaFound);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<PlacaDto> updatePlaca(@PathVariable UUID id, @RequestBody PlacaToSaveDto placaToSaveDto){
        try {
            PlacaDto placaUpdated = placaService.update(id, placaToSaveDto);
            return ResponseEntity.ok().body(placaUpdated);
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlaca(@PathVariable UUID id){
        try {
            placaService.delete(id);
            return ResponseEntity.ok().body("Placa con id " + id + " eliminada correctamente");
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

}
