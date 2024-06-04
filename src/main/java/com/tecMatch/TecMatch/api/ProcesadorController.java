package com.tecMatch.TecMatch.api;

import com.tecMatch.TecMatch.dto.procesador.ProcesadorDto;
import com.tecMatch.TecMatch.dto.procesador.ProcesadorToSaveDto;
import com.tecMatch.TecMatch.service.procesador.ProcesadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/PROCESADOR")
public class ProcesadorController {
    private final ProcesadorService procesadorService;

    public ProcesadorController(ProcesadorService procesadorService) {
        this.procesadorService = procesadorService;
    }

    @PostMapping()
    public ResponseEntity<ProcesadorDto> createProcesador(@RequestBody ProcesadorToSaveDto procesadorToSaveDto) {
        ProcesadorDto procesadorSaved = procesadorService.save(procesadorToSaveDto);
        return ResponseEntity.ok().body(procesadorSaved);
    }

    @GetMapping()
    public ResponseEntity<List<ProcesadorDto>> findAllProcesadors() {
        List<ProcesadorDto> allProcesadors = procesadorService.findAll();
        return ResponseEntity.ok().body(allProcesadors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcesadorDto> findProcesadorById(@PathVariable UUID id) {
        try {
            ProcesadorDto procesadorFound = procesadorService.findById(id);
            return ResponseEntity.ok().body(procesadorFound);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/pieza/{id}")
    public ResponseEntity<ProcesadorDto> findProcesadorByPiezaId(@PathVariable UUID id) {
        try {
            ProcesadorDto procesadorFound = procesadorService.findByPiezaId(id);
            return ResponseEntity.ok().body(procesadorFound);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProcesadorDto> updateProcesador(@PathVariable UUID id, @RequestBody ProcesadorToSaveDto procesadorToSaveDto){
        try {
            ProcesadorDto procesadorUpdated = procesadorService.update(id, procesadorToSaveDto);
            return ResponseEntity.ok().body(procesadorUpdated);
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProcesador(@PathVariable UUID id) {
        try {
            procesadorService.delete(id);
            return ResponseEntity.ok().body("Procesador con id " + id + " eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
