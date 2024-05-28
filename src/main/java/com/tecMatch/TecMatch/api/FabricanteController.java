package com.tecMatch.TecMatch.api;

import com.tecMatch.TecMatch.dto.fabricante.FabricanteDto;
import com.tecMatch.TecMatch.dto.fabricante.FabricanteToSaveDto;
import com.tecMatch.TecMatch.service.fabricante.FabricanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/fabricantes")
public class FabricanteController {
    private final FabricanteService fabricanteService;
    public FabricanteController(FabricanteService fabricanteService){
        this.fabricanteService = fabricanteService;
    }
    @PostMapping()
    public ResponseEntity<FabricanteDto> createFabricante(@RequestBody FabricanteToSaveDto fabricanteToSaveDto){
        FabricanteDto fabricanteSaved = fabricanteService.save(fabricanteToSaveDto);
        return ResponseEntity.ok().body(fabricanteSaved);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FabricanteDto> getFabricanteById(@PathVariable("id") UUID id){
        try{
            FabricanteDto fabricanteFound = fabricanteService.findById(id);
            return ResponseEntity.ok().body(fabricanteFound);
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping()
    public ResponseEntity<List<FabricanteDto>> getAllFabricantes(){
        List<FabricanteDto> allFabricantes = fabricanteService.findAll();
        return ResponseEntity.ok().body(allFabricantes);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FabricanteDto> updateFabricante(@PathVariable UUID id, @RequestBody FabricanteToSaveDto fabricanteToUpdate){
        try{
            FabricanteDto fabricanteUpdated = fabricanteService.update(id,fabricanteToUpdate);
            return ResponseEntity.ok().body(fabricanteUpdated);
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFabricante(@PathVariable("id") UUID id){
        try{
            fabricanteService.delete(id);
            return ResponseEntity.ok().body("Fabricante con id "+id+" eliminado correctamente");
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/nombre")
    public ResponseEntity<List<FabricanteDto>> getFabricanteByNombre(@RequestParam String contains){
        List<FabricanteDto> socketsFound = fabricanteService.findByNombreContainingIgnoreCase(contains);
        return ResponseEntity.ok().body(socketsFound);
    }
}
