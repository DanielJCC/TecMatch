package com.tecMatch.TecMatch.api;

import com.tecMatch.TecMatch.dto.socket.SocketDto;
import com.tecMatch.TecMatch.dto.socket.SocketToSaveDto;
import com.tecMatch.TecMatch.service.socket.SocketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping()
    public ResponseEntity<String> deleteAllSocket(){
        socketService.deleteAll();
        return ResponseEntity.ok().body("Todos los sockets fueron eliminados correctamente");
    }
}
