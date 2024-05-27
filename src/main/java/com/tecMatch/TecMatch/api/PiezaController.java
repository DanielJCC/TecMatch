package com.tecMatch.TecMatch.api;

import com.tecMatch.TecMatch.dto.pieza.PiezaDto;
import com.tecMatch.TecMatch.dto.pieza.PiezaToSaveDto;
import com.tecMatch.TecMatch.service.pieza.PiezaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/piezas")
public class PiezaController {
    private final PiezaService piezaService;
    public PiezaController(PiezaService piezaService){
        this.piezaService = piezaService;
    }
    @PostMapping()
    public ResponseEntity<PiezaDto> createPieza(@RequestBody PiezaToSaveDto piezaToSave){
        PiezaDto piezaSaved = piezaService.save(piezaToSave);
        return ResponseEntity.ok().body(piezaSaved);
    }
    @GetMapping()
    public ResponseEntity<List<PiezaDto>> getPieza(){
        List<PiezaDto> allPiezas = piezaService.findAll();
        return ResponseEntity.ok().body(allPiezas);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PiezaDto> getPiezaById(@PathVariable("id") UUID id){
        try{
            PiezaDto piezaFound = piezaService.findById(id);
            return ResponseEntity.ok().body(piezaFound);
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") UUID id){
        try{
            piezaService.deleteById(id);
            return ResponseEntity.ok().body("Pieza "+id+" eliminada correctamente");
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
