package com.tecMatch.TecMatch.service.placa;

import com.tecMatch.TecMatch.dto.placa.PlacaDto;
import com.tecMatch.TecMatch.dto.placa.PlacaToSaveDto;
import com.tecMatch.TecMatch.entities.Pieza;
import com.tecMatch.TecMatch.entities.Placa;
import com.tecMatch.TecMatch.mappers.PlacaMapper;
import com.tecMatch.TecMatch.repository.PiezaRepository;
import com.tecMatch.TecMatch.repository.PlacaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlacaServiceImpl implements PlacaService{
    private final PlacaMapper placaMapper;
    private final PlacaRepository placaRepository;
    private final PiezaRepository piezaRepository;
    public PlacaServiceImpl(PlacaMapper placaMapper, PlacaRepository placaRepository,
                            PiezaRepository piezaRepository){
        this.placaMapper = placaMapper;
        this.placaRepository = placaRepository;
        this.piezaRepository = piezaRepository;
    }

    @Override
    public PlacaDto save(PlacaToSaveDto placaToSaveDto) {
        Pieza piezaFound = piezaRepository.findById(placaToSaveDto.pieza().id())
                .orElseThrow(()->new RuntimeException("Pieza no encontrada"));
        Placa placaToSave = placaMapper.ToSaveDtoToEntity(placaToSaveDto);
        placaToSave.setPieza(piezaFound);
        Placa placaSaved = placaRepository.save(placaToSave);
        return placaMapper.EntityToDto(placaSaved);
    }

    @Override
    public List<PlacaDto> findAll() {
        List<Placa> allPlacas = placaRepository.findAll();
        return allPlacas.stream().parallel().map(placaMapper::EntityToDto).toList();
    }

    @Override
    public PlacaDto findById(UUID idToFind) {
        Placa placaFound = placaRepository.findById(idToFind)
                .orElseThrow(()->new RuntimeException("Placa no encontrada"));
        return placaMapper.EntityToDto(placaFound);
    }

    @Override
    public PlacaDto findByPiezaId(UUID idPieza) {
        Placa placaFound = placaRepository.findByPiezaId(idPieza)
                .orElseThrow(()->new RuntimeException("Placa no encontrada"));
        return placaMapper.EntityToDto(placaFound);
    }

    @Override
    public PlacaDto update(UUID idToUpdate, PlacaToSaveDto placaToSaveDto) {
        return null;
    }

    @Override
    public void delete(UUID idToDelete) {
        Placa placaFound = placaRepository.findById(idToDelete)
                .orElseThrow(()->new RuntimeException("Placa no encontrada"));
        placaRepository.delete(placaFound);
    }
}
