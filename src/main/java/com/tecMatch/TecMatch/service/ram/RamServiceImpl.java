package com.tecMatch.TecMatch.service.ram;

import com.tecMatch.TecMatch.dto.ram.RamDto;
import com.tecMatch.TecMatch.dto.ram.RamToSaveDto;
import com.tecMatch.TecMatch.entities.Pieza;
import com.tecMatch.TecMatch.entities.Ram;
import com.tecMatch.TecMatch.mappers.RamMapper;
import com.tecMatch.TecMatch.repository.PiezaRepository;
import com.tecMatch.TecMatch.repository.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RamServiceImpl implements RamService{
    private final RamRepository ramRepository;
    private final RamMapper ramMapper;
    private final PiezaRepository piezaRepository;
    @Autowired
    public RamServiceImpl(RamRepository ramRepository,PiezaRepository piezaRepository,
                          RamMapper ramMapper){
        this.ramMapper = ramMapper;
        this.ramRepository = ramRepository;
        this.piezaRepository = piezaRepository;
    }
    @Override
    public RamDto save(RamToSaveDto ramToSaveDto) {
        Pieza piezaFound = piezaRepository.findById(ramToSaveDto.pieza().id())
                .orElseThrow(()->new RuntimeException("Pieza no encontrada"));
        Ram ramToSave = ramMapper.ToSaveDtoToEntity(ramToSaveDto);
        ramToSave.setPieza(piezaFound);
        Ram ramSaved = ramRepository.save(ramToSave);
        return ramMapper.EntityToDto(ramSaved);
    }

    @Override
    public RamDto findById(UUID idToFind) {
        Ram ramFound = ramRepository.findById(idToFind)
                .orElseThrow(()->new RuntimeException("Ram no encontrada"));
        return ramMapper.EntityToDto(ramFound);
    }

    @Override
    public List<RamDto> findAll() {
        List<Ram> allRams = ramRepository.findAll();
        return allRams.stream().parallel().map(ramMapper::EntityToDto).toList();
    }

    @Override
    public RamDto update(UUID idToUpdate, RamToSaveDto ramToUpdateDto) {
        Ram ramFound = ramRepository.findById(idToUpdate)
                .orElseThrow(()->new RuntimeException("Ram no encontrada"));
        ramMapper.updateRamFromToSaveDto(ramToUpdateDto,ramFound);
        Ram ramUpdated = ramRepository.save(ramFound);
        return ramMapper.EntityToDto(ramUpdated);
    }

    @Override
    public void delete(UUID idToDelete) {
        Ram ramFound = ramRepository.findById(idToDelete)
                .orElseThrow(()->new RuntimeException("Ram no encontrada"));
        ramRepository.delete(ramFound);
    }

    @Override
    public RamDto findByPiezaId(UUID idPieza) {
        Ram ramFound = ramRepository.findByPiezaId(idPieza)
                .orElseThrow(()->new RuntimeException("Pieza no fue encontrada"));
        return ramMapper.EntityToDto(ramFound);
    }
}
