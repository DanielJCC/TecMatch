package com.tecMatch.TecMatch.service.pieza;

import com.tecMatch.TecMatch.dto.pieza.PiezaDto;
import com.tecMatch.TecMatch.dto.pieza.PiezaToSaveDto;
import com.tecMatch.TecMatch.entities.Fabricante;
import com.tecMatch.TecMatch.entities.Pieza;
import com.tecMatch.TecMatch.entities.Socket;
import com.tecMatch.TecMatch.mappers.PiezaMapper;
import com.tecMatch.TecMatch.repository.FabricanteRepository;
import com.tecMatch.TecMatch.repository.PiezaRepository;
import com.tecMatch.TecMatch.repository.SocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PiezaServiceImpl implements PiezaService{
    private final PiezaRepository piezaRepository;
    private final PiezaMapper piezaMapper;
    private final SocketRepository socketRepository;
    private final FabricanteRepository fabricanteRepository;
    @Autowired
    public PiezaServiceImpl(PiezaRepository piezaRepository,PiezaMapper piezaMapper,
                            SocketRepository socketRepository, FabricanteRepository fabricanteRepository){
        this.piezaRepository = piezaRepository;
        this.piezaMapper = piezaMapper;
        this.socketRepository = socketRepository;
        this.fabricanteRepository = fabricanteRepository;
    }
    @Override
    public PiezaDto save(PiezaToSaveDto piezaToSaveDto) {
        Socket socketFound = socketRepository.findById(piezaToSaveDto.socket().id())
                .orElseThrow(()->new RuntimeException("Socket no encontrado"));
        Fabricante fabricanteFound = fabricanteRepository.findById(piezaToSaveDto.fabricante().id())
                .orElseThrow(()->new RuntimeException("Fabricante no encontrado"));
        Pieza piezaToSave = piezaMapper.ToSaveDtoToEntity(piezaToSaveDto);
        piezaToSave.setFabricante(fabricanteFound);
        piezaToSave.setSocket(socketFound);
        Pieza piezaSaved = piezaRepository.save(piezaToSave);
        PiezaDto piezaMostrada = piezaMapper.EntityToDto(piezaSaved);
        return piezaMapper.EntityToDto(piezaSaved);
    }

    @Override
    public PiezaDto findById(UUID idToFind) {
        Pieza piezaFound = piezaRepository.findById(idToFind)
                .orElseThrow(()->new RuntimeException("Pieza no encontrada"));
        return piezaMapper.EntityToDto(piezaFound);
    }

    @Override
    public List<PiezaDto> findAll() {
        List<Pieza> allPiezas = piezaRepository.findAll();
        return allPiezas.stream().parallel().map(piezaMapper::EntityToDto).toList();
    }

    @Override
    public PiezaDto update(UUID idToUpdate, PiezaToSaveDto piezaToUpdate) {
        Pieza piezaFound = piezaRepository.findById(idToUpdate)
                .orElseThrow(()->new RuntimeException("Pieza no encontrada"));
        piezaFound.setNombre(piezaToUpdate.nombre() != null ? piezaToUpdate.nombre() : piezaFound.getNombre());
        piezaFound.setModelo(piezaToUpdate.modelo() != null ? piezaToUpdate.modelo() : piezaFound.getModelo());
        piezaFound.setPrecio(piezaToUpdate.precio() != null ? piezaToUpdate.precio() : piezaFound.getPrecio());
        piezaFound.setVoltaje(piezaToUpdate.voltaje() != null ? piezaToUpdate.voltaje() : piezaFound.getVoltaje());
        piezaFound.setImagen(piezaToUpdate.imagen() != null ? piezaToUpdate.imagen() : piezaFound.getImagen());
        Pieza piezaUpdated = piezaRepository.save(piezaFound);
        return piezaMapper.EntityToDto(piezaUpdated);
    }

    @Override
    public void deleteById(UUID idToDelete) {
        Pieza piezaFound = piezaRepository.findById(idToDelete)
                .orElseThrow(()->new RuntimeException("Pieza no encontrada"));
        piezaRepository.delete(piezaFound);
    }

    @Override
    public List<PiezaDto> findByNombreIgnoringCase(String nombre) {
        List<Pieza> piezasFound = piezaRepository.findByNombreContainingIgnoreCase(nombre);
        return piezasFound.stream().parallel().map(piezaMapper::EntityToDto).toList();
    }

    @Override
    public List<PiezaDto> findByModeloIgnoringCase(String modelo) {
        List<Pieza> piezasFound = piezaRepository.findByModeloContainingIgnoreCase(modelo);
        return piezasFound.stream().parallel().map(piezaMapper::EntityToDto).toList();
    }

    @Override
    public List<PiezaDto> findByPrecioMenorQue(Float precio) {
        List<Pieza> piezasFound = piezaRepository.findByPrecioLessThanEqual(precio);
        return piezasFound.stream().parallel().map(piezaMapper::EntityToDto).toList();
    }

    @Override
    public List<PiezaDto> findByVoltaje(Float voltaje) {
        List<Pieza> piezasFound = piezaRepository.findByVoltaje(voltaje);
        return piezasFound.stream().parallel().map(piezaMapper::EntityToDto).toList();
    }

    @Override
    public List<PiezaDto> findByFabricanteId(UUID id) {
        List<Pieza> piezasFound = piezaRepository.findByFabricanteId(id);
        return piezasFound.stream().parallel().map(piezaMapper::EntityToDto).toList();
    }

    @Override
    public List<PiezaDto> findBySocketId(UUID id) {
        List<Pieza> piezasFound = piezaRepository.findBySocketId(id);
        return piezasFound.stream().parallel().map(piezaMapper::EntityToDto).toList();
    }
}
