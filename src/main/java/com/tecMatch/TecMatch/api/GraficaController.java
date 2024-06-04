package com.tecMatch.TecMatch.api;

import com.tecMatch.TecMatch.dto.grafica.GraficaDto;
import com.tecMatch.TecMatch.dto.grafica.GraficaToSaveDto;
import com.tecMatch.TecMatch.service.grafica.GraficaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/GRAFICA")
public class GraficaController {
    private final GraficaService graficaService;
    public GraficaController(GraficaService graficaService){
        this.graficaService = graficaService;
    }
    @PostMapping()
    public ResponseEntity<GraficaDto> createGrafica(@RequestBody GraficaToSaveDto graficaToSaveDto){
        GraficaDto graficaSaved = graficaService.save(graficaToSaveDto);
        return ResponseEntity.ok().body(graficaSaved);
    }
    @GetMapping()
    public ResponseEntity<List<GraficaDto>> findAllGraficas(){
        List<GraficaDto> allGraficas = graficaService.findAll();
        return ResponseEntity.ok().body(allGraficas);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GraficaDto> findGraficaById(@PathVariable UUID id){
        try{
            GraficaDto graficaFound = graficaService.findById(id);
            return ResponseEntity.ok().body(graficaFound);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/pieza/{id}")
    public ResponseEntity<GraficaDto> findGraficaByPiezaId(@PathVariable UUID id){
        try{
            GraficaDto graficaFound = graficaService.findByPiezaId(id);
            return ResponseEntity.ok().body(graficaFound);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<GraficaDto> updateGrafica(@PathVariable UUID id, @RequestBody GraficaToSaveDto graficaToSaveDto){
        try {
            GraficaDto graficaUpdated = graficaService.update(id, graficaToSaveDto);
            return ResponseEntity.ok().body(graficaUpdated);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGrafica(@PathVariable UUID id){
        try {
            graficaService.delete(id);
            return ResponseEntity.ok().body("Gráfica con id "+id+" eliminada correctamente");
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
