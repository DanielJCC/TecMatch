package com.tecMatch.TecMatch.api;

import com.tecMatch.TecMatch.dto.piezaEnListaConstruccion.PiezaEnListaConstruccionDto;
import com.tecMatch.TecMatch.dto.piezaEnListaConstruccion.PiezaEnListaConstruccionToSaveDto;
import com.tecMatch.TecMatch.service.piezaEnListaConstruccion.PiezaEnListaConstruccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/piezas-en-lista-construccion")
public class PiezaEnListaConstruccionController {
    private final PiezaEnListaConstruccionService piezaEnListaConstruccionService;
    public PiezaEnListaConstruccionController(PiezaEnListaConstruccionService piezaEnListaConstruccionService){
        this.piezaEnListaConstruccionService = piezaEnListaConstruccionService;
    }
    @PostMapping()
    public ResponseEntity<PiezaEnListaConstruccionDto> createPiezaEnListaConstruccion(@RequestBody PiezaEnListaConstruccionToSaveDto piezaEnListaConstruccionToSave){
        PiezaEnListaConstruccionDto piezaEnListaConstruccionSaved = piezaEnListaConstruccionService.save(piezaEnListaConstruccionToSave);
        return ResponseEntity.ok().body(piezaEnListaConstruccionSaved);
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<PiezaEnListaConstruccionDto>> findByUsuarioId(@PathVariable("id") UUID usuarioId){
        List<PiezaEnListaConstruccionDto> piezasEnListaConstruccionFound = piezaEnListaConstruccionService.findByUsuarioId(usuarioId);
        return ResponseEntity.ok().body(piezasEnListaConstruccionFound);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") UUID id){
        try{
            piezaEnListaConstruccionService.delete(id);
            return ResponseEntity.ok().body("Pieza en lista de construcción con id  "+id+" eliminada correctamente");
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
