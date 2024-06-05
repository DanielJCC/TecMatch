package com.tecMatch.TecMatch.service.piezaDeseada;

import com.tecMatch.TecMatch.dto.piezaDeseada.PiezaDeseadaDto;
import com.tecMatch.TecMatch.dto.piezaDeseada.PiezaDeseadaToSaveDto;
import com.tecMatch.TecMatch.entities.Pieza;
import com.tecMatch.TecMatch.entities.PiezaDeseada;
import com.tecMatch.TecMatch.entities.Usuario;
import com.tecMatch.TecMatch.mappers.PiezaDeseadaMapper;
import com.tecMatch.TecMatch.repository.PiezaDeseadaRepository;
import com.tecMatch.TecMatch.repository.PiezaRepository;
import com.tecMatch.TecMatch.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PiezaDeseadaServiceImpl implements PiezaDeseadaService{
    private final PiezaDeseadaMapper piezaDeseadaMapper;
    private final PiezaDeseadaRepository piezaDeseadaRepository;
    private final PiezaRepository piezaRepository;
    private final UsuarioRepository usuarioRepository;
    public PiezaDeseadaServiceImpl(PiezaDeseadaMapper piezaDeseadaMapper,PiezaDeseadaRepository piezaDeseadaRepository,
                                   PiezaRepository piezaRepository, UsuarioRepository usuarioRepository){
        this.piezaDeseadaMapper = piezaDeseadaMapper;
        this.piezaDeseadaRepository = piezaDeseadaRepository;
        this.piezaRepository = piezaRepository;
        this.usuarioRepository= usuarioRepository;
    }

    @Override
    public PiezaDeseadaDto save(PiezaDeseadaToSaveDto piezaDeseadaToSaveDto) {
        Usuario usuarioFound = usuarioRepository.findById(piezaDeseadaToSaveDto.usuario().id())
                .orElseThrow(()->new RuntimeException("Usuario no fue encontrado"));
        Pieza piezaFound = piezaRepository.findById(piezaDeseadaToSaveDto.pieza().id())
                .orElseThrow(()->new RuntimeException("Pieza no fue encontrada"));
        if(piezaDeseadaRepository.existsByUsuarioIdAndPiezaId(usuarioFound.getId(),piezaFound.getId())){
            throw new RuntimeException("La pieza ya se encuentra en la lista de deseadas.");
        }
        PiezaDeseada piezaToSave = piezaDeseadaMapper.ToSaveDtoToEntity(piezaDeseadaToSaveDto);
        piezaToSave.setPieza(piezaFound);
        piezaToSave.setUsuario(usuarioFound);
        PiezaDeseada piezaDeseadaSaved = piezaDeseadaRepository.save(piezaToSave);
        return piezaDeseadaMapper.EntityToDto(piezaDeseadaSaved);
    }

    @Override
    public List<PiezaDeseadaDto> findByUsuarioId(UUID idUsuario) {
        List<PiezaDeseada> piezaDeseadaFound = piezaDeseadaRepository.findByUsuarioId(idUsuario);
        return piezaDeseadaFound.stream().parallel().map(piezaDeseadaMapper::EntityToDto).toList();
    }

    @Override
    public void delete(UUID idToDelete) {
        PiezaDeseada piezaDeseadaFound = piezaDeseadaRepository.findById(idToDelete)
                .orElseThrow(()->new RuntimeException("Pieza en Lista de deseados no fue encontrada"));
        piezaDeseadaRepository.delete(piezaDeseadaFound);
    }
}
