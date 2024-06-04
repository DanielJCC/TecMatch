package com.tecMatch.TecMatch.api;

import com.tecMatch.TecMatch.dto.ram.RamDto;
import com.tecMatch.TecMatch.dto.ram.RamToSaveDto;
import com.tecMatch.TecMatch.service.ram.RamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/RAM")
public class RamController {
    private final RamService ramService;
    public RamController(RamService ramService){this.ramService = ramService;}

    @PostMapping()
    public ResponseEntity<RamDto> createRam(@RequestBody RamToSaveDto ramToSaveDto){
        RamDto ramSaved = ramService.save(ramToSaveDto);
        return ResponseEntity.ok().body(ramSaved);
    }
    @GetMapping()
    public ResponseEntity<List<RamDto>> findAllRams(){
        List<RamDto> allRams = ramService.findAll();
        return ResponseEntity.ok().body(allRams);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RamDto> findRamById(@PathVariable UUID id){
        try{
            RamDto ramFound = ramService.findById(id);
            return ResponseEntity.ok().body(ramFound);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/pieza/{id}")
    public ResponseEntity<RamDto> findRamByPiezaId(@PathVariable UUID id){
        try{
            RamDto ramFound = ramService.findByPiezaId(id);
            return ResponseEntity.ok().body(ramFound);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<RamDto> updateRam(@PathVariable UUID id, @RequestBody RamToSaveDto ramToSaveDto){
        try {
            RamDto ramUpdated = ramService.update(id, ramToSaveDto);
            return ResponseEntity.ok().body(ramUpdated);
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRam(@PathVariable UUID id){
        try {
            ramService.delete(id);
            return ResponseEntity.ok().body("Ram con id "+id+" eliminada correctamente");
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
