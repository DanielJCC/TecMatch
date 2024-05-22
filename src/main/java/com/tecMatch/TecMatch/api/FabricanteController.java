package com.tecMatch.TecMatch.api;

import com.tecMatch.TecMatch.dto.fabricante.FabricanteDto;
import com.tecMatch.TecMatch.dto.fabricante.FabricanteToSaveDto;
import com.tecMatch.TecMatch.service.fabricante.FabricanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
