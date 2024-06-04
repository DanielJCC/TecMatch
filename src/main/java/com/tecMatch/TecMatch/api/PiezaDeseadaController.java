package com.tecMatch.TecMatch.api;

import com.tecMatch.TecMatch.dto.piezaDeseada.PiezaDeseadaDto;
import com.tecMatch.TecMatch.dto.piezaDeseada.PiezaDeseadaToSaveDto;
import com.tecMatch.TecMatch.service.piezaDeseada.PiezaDeseadaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/piezas-deseadas")
public class PiezaDeseadaController {
    private final PiezaDeseadaService piezaDeseadaService;
    public PiezaDeseadaController(PiezaDeseadaService piezaDeseadaService){
        this.piezaDeseadaService = piezaDeseadaService;
    }
    @PostMapping()
    public ResponseEntity<PiezaDeseadaDto> createPiezaDeseada(@RequestBody PiezaDeseadaToSaveDto piezaDeseadaToSave){
        PiezaDeseadaDto piezaDeseadaSaved = piezaDeseadaService.save(piezaDeseadaToSave);
        return ResponseEntity.ok().body(piezaDeseadaSaved);
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<PiezaDeseadaDto>> findByUsuarioId(@PathVariable("id") UUID usuarioId){
        List<PiezaDeseadaDto> piezasDeseadasFound = piezaDeseadaService.findByUsuarioId(usuarioId);
        return ResponseEntity.ok().body(piezasDeseadasFound);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") UUID id){
        try{
            piezaDeseadaService.delete(id);
            return ResponseEntity.ok().body("Pieza en lista de deseos con id  "+id+" eliminada correctamente");
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
