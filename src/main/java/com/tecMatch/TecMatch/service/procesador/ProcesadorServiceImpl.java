package com.tecMatch.TecMatch.service.procesador;

import com.tecMatch.TecMatch.dto.procesador.ProcesadorDto;
import com.tecMatch.TecMatch.dto.procesador.ProcesadorToSaveDto;
import com.tecMatch.TecMatch.entities.Pieza;
import com.tecMatch.TecMatch.entities.Procesador;
import com.tecMatch.TecMatch.mappers.ProcesadorMapper;
import com.tecMatch.TecMatch.repository.PiezaRepository;
import com.tecMatch.TecMatch.repository.ProcesadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProcesadorServiceImpl implements ProcesadorService{
    private final ProcesadorRepository procesadorRepository;
    private final ProcesadorMapper procesadorMapper;
    private final PiezaRepository piezaRepository;
    public ProcesadorServiceImpl(ProcesadorRepository procesadorRepository, PiezaRepository piezaRepository,
                                 ProcesadorMapper procesadorMapper){
        this.procesadorRepository = procesadorRepository;
        this.procesadorMapper = procesadorMapper;
        this.piezaRepository = piezaRepository;
    }

    @Override
    public ProcesadorDto save(ProcesadorToSaveDto procesadorToSaveDto) {
        Pieza piezaFound = piezaRepository.findById(procesadorToSaveDto.pieza().id())
                .orElseThrow(()->new RuntimeException("Pieza no encontrada"));
        Procesador procesadorToSave = procesadorMapper.ToSaveDtoToEntity(procesadorToSaveDto);
        procesadorToSave.setPieza(piezaFound);
        Procesador procesadorSaved = procesadorRepository.save(procesadorToSave);
        return procesadorMapper.EntityToDto(procesadorSaved);
    }

    @Override
    public List<ProcesadorDto> findAll() {
        List<Procesador> allProcesadores = procesadorRepository.findAll();
        return allProcesadores.stream().parallel().map(procesadorMapper::EntityToDto).toList();
    }

    @Override
    public ProcesadorDto findById(UUID idToFind) {
        Procesador procesadorFound = procesadorRepository.findById(idToFind)
                .orElseThrow(()->new RuntimeException("Procesador no fue encontrado"));
        return procesadorMapper.EntityToDto(procesadorFound);
    }

    @Override
    public ProcesadorDto findByPiezaId(UUID idPieza) {
        Procesador procesadorFound = procesadorRepository.findByPiezaId(idPieza)
                .orElseThrow(()->new RuntimeException("Procesador no fue encontrado"));
        return procesadorMapper.EntityToDto(procesadorFound);
    }

    @Override
    public ProcesadorDto update(UUID idToUpdate, ProcesadorToSaveDto procesadorToSaveDto) {
        return null;
    }

    @Override
    public void delete(UUID idToDelete) {
        Procesador procesadorFound = procesadorRepository.findById(idToDelete)
                .orElseThrow(()->new RuntimeException("Procesador no fue encontrado"));
        procesadorRepository.delete(procesadorFound);
    }
}
