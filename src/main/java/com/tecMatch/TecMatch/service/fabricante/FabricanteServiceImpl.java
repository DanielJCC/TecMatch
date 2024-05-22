package com.tecMatch.TecMatch.service.fabricante;

import com.tecMatch.TecMatch.dto.fabricante.FabricanteDto;
import com.tecMatch.TecMatch.dto.fabricante.FabricanteToSaveDto;
import com.tecMatch.TecMatch.entities.Fabricante;
import com.tecMatch.TecMatch.mappers.FabricanteMapper;
import com.tecMatch.TecMatch.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FabricanteServiceImpl implements FabricanteService{
    private final FabricanteRepository fabricanteRepository;
    private final FabricanteMapper fabricanteMapper;
    @Autowired
    public FabricanteServiceImpl(FabricanteRepository fabricanteRepository,
                                 FabricanteMapper fabricanteMapper){
        this.fabricanteRepository = fabricanteRepository;
        this.fabricanteMapper = fabricanteMapper;
    }
    @Override
    public FabricanteDto save(FabricanteToSaveDto fabricanteToSaveDto) {
        Fabricante fabricanteToSave = fabricanteMapper.ToSaveDtoToEntity(fabricanteToSaveDto);
        Fabricante fabricanteSaved = fabricanteRepository.save(fabricanteToSave);
        return fabricanteMapper.EntityToDto(fabricanteSaved);
    }

    @Override
    public FabricanteDto findById(UUID idToFind) {
        Fabricante fabricanteFound = fabricanteRepository.findById(idToFind)
                .orElseThrow(()->new RuntimeException("Fabricante no encontrado"));
        return fabricanteMapper.EntityToDto(fabricanteFound);
    }
}
