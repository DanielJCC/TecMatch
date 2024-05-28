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
    @PutMapping("/{id}")
    public ResponseEntity<PiezaDto> updatePieza(@PathVariable("id") UUID id,@RequestBody PiezaToSaveDto piezaToUpdate){
        try{
            PiezaDto piezaUpdated = piezaService.update(id,piezaToUpdate);
            return ResponseEntity.ok().body(piezaUpdated);
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
    @GetMapping("/nombre")
    public ResponseEntity<List<PiezaDto>> findPiezaByNombreContaining(@RequestParam String contains){
        List<PiezaDto> piezasFound = piezaService.findByNombreIgnoringCase(contains);
        return ResponseEntity.ok().body(piezasFound);
    }
    @GetMapping("/modelo")
    public ResponseEntity<List<PiezaDto>> findPiezaByModeloContaining(@RequestParam String contains){
        List<PiezaDto> piezasFound = piezaService.findByModeloIgnoringCase(contains);
        return ResponseEntity.ok().body(piezasFound);
    }
    @GetMapping("/precio")
    public ResponseEntity<List<PiezaDto>> findPiezaByPrecioMenorQue(@RequestParam Float lessThan){
        List<PiezaDto> piezasFound = piezaService.findByPrecioMenorQue(lessThan);
        return ResponseEntity.ok().body(piezasFound);
    }
    @GetMapping("/voltaje")
    public ResponseEntity<List<PiezaDto>> findPiezaByVoltaje(@RequestParam Float voltaje){
        List<PiezaDto> piezasFound = piezaService.findByVoltaje(voltaje);
        return ResponseEntity.ok().body(piezasFound);
    }
    @GetMapping("/fabricante/{id}")
    public ResponseEntity<List<PiezaDto>> findByFabricanteId(@PathVariable("id") UUID fabricanteId){
        List<PiezaDto> piezasFound = piezaService.findByFabricanteId(fabricanteId);
        return ResponseEntity.ok().body(piezasFound);
    }
    @GetMapping("/socket/{id}")
    public ResponseEntity<List<PiezaDto>> findBySocketId(@PathVariable("id") UUID socketId){
        List<PiezaDto> piezasFound = piezaService.findBySocketId(socketId);
        return ResponseEntity.ok().body(piezasFound);
    }
}
