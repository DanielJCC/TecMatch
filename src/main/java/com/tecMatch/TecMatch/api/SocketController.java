package com.tecMatch.TecMatch.api;

import com.tecMatch.TecMatch.dto.socket.SocketDto;
import com.tecMatch.TecMatch.dto.socket.SocketToSaveDto;
import com.tecMatch.TecMatch.service.socket.SocketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/sockets")
public class SocketController {
    private final SocketService socketService;
    public SocketController(SocketService socketService){
        this.socketService = socketService;
    }
    @PostMapping()
    public ResponseEntity<SocketDto> createSocket(@RequestBody SocketToSaveDto socketToSaveDto){
        SocketDto socketSaved = socketService.save(socketToSaveDto);
        return ResponseEntity.ok().body(socketSaved);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SocketDto> getSocketById(@PathVariable("id") UUID id){
        try{
            SocketDto socketFound = socketService.findById(id);
            return ResponseEntity.ok().body(socketFound);
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping()
    public ResponseEntity<List<SocketDto>> getAllSockets(){
        List<SocketDto> allSockets = socketService.findAll();
        return ResponseEntity.ok().body(allSockets);
    }
    @PutMapping("/{id}")
    public ResponseEntity<SocketDto> updateSocket(@PathVariable("id") UUID id, @RequestBody SocketToSaveDto socketToUpdate){
        try {
            SocketDto socketUpdated = socketService.update(id,socketToUpdate);
            return ResponseEntity.ok().body(socketUpdated);
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSocket(@PathVariable("id") UUID id){
        try {
            socketService.delete(id);
            return ResponseEntity.ok().body("Socket con id " + id + " fue eliminado correctamente");
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/nombre")
    public ResponseEntity<List<SocketDto>> getSocketsByNombre(@RequestParam String contains){
        List<SocketDto> socketsFound = socketService.findByNombreIgnoringCase(contains);
        return ResponseEntity.ok().body(socketsFound);
    }
    @GetMapping("/tipo-socket/{id}")
    public ResponseEntity<List<SocketDto>> getSocketsByTipoSocketId(@PathVariable UUID id){
        List<SocketDto> socketsFound = socketService.findByTipoSocketId(id);
        return ResponseEntity.ok().body(socketsFound);
    }
}
