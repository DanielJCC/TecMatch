package com.tecMatch.TecMatch.service.grafica;

import com.tecMatch.TecMatch.dto.grafica.GraficaDto;
import com.tecMatch.TecMatch.dto.grafica.GraficaToSaveDto;
import com.tecMatch.TecMatch.entities.Grafica;
import com.tecMatch.TecMatch.entities.Pieza;
import com.tecMatch.TecMatch.mappers.GraficaMapper;
import com.tecMatch.TecMatch.repository.GraficaRepository;
import com.tecMatch.TecMatch.repository.PiezaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GraficaServiceImpl implements GraficaService{
    private final GraficaMapper graficaMapper;
    private final GraficaRepository graficaRepository;
    private final PiezaRepository piezaRepository;
    public GraficaServiceImpl(GraficaMapper graficaMapper, PiezaRepository piezaRepository,
                              GraficaRepository graficaRepository){
        this.graficaMapper = graficaMapper;
        this.graficaRepository = graficaRepository;
        this.piezaRepository = piezaRepository;
    }
    @Override
    public GraficaDto save(GraficaToSaveDto graficaToSaveDto) {
        Pieza piezaFound = piezaRepository.findById(graficaToSaveDto.pieza().id())
                .orElseThrow(()->new RuntimeException("Pieza no encontrada"));
        Grafica graficaToSave = graficaMapper.ToSaveDtoToEntity(graficaToSaveDto);
        graficaToSave.setPieza(piezaFound);
        Grafica graficaSaved = graficaRepository.save(graficaToSave);
        return graficaMapper.EntityToDto(graficaSaved);
    }

    @Override
    public List<GraficaDto> findAll() {
        List<Grafica> allGraficas = graficaRepository.findAll();
        return allGraficas.stream().parallel().map(graficaMapper::EntityToDto).toList();
    }

    @Override
    public GraficaDto findById(UUID idToFind) {
        Grafica graficaFound = graficaRepository.findById(idToFind)
                .orElseThrow(()->new RuntimeException("Grafica no fue encontrada"));
        return graficaMapper.EntityToDto(graficaFound);
    }

    @Override
    public GraficaDto findByPiezaId(UUID idPieza) {
        Grafica graficaFound = graficaRepository.findByPiezaId(idPieza)
                .orElseThrow(()->new RuntimeException("Grafica no fue encontrada"));
        return graficaMapper.EntityToDto(graficaFound);
    }

    @Override
    public GraficaDto update(UUID idToUpdate, GraficaToSaveDto graficaToSaveDto) {
        return null;
    }

    @Override
    public void delete(UUID idToDelete) {
        Grafica graficaFound = graficaRepository.findById(idToDelete)
                .orElseThrow(()->new RuntimeException("Grafica no fue encontrada"));
        graficaRepository.delete(graficaFound);
    }
}
