package com.tecMatch.TecMatch.service.piezaEnListaConstruccion;

import com.tecMatch.TecMatch.dto.piezaEnListaConstruccion.PiezaEnListaConstruccionDto;
import com.tecMatch.TecMatch.dto.piezaEnListaConstruccion.PiezaEnListaConstruccionToSaveDto;
import com.tecMatch.TecMatch.entities.Pieza;
import com.tecMatch.TecMatch.entities.PiezaEnListaConstruccion;
import com.tecMatch.TecMatch.entities.Usuario;
import com.tecMatch.TecMatch.mappers.PiezaEnListaConstruccionMapper;
import com.tecMatch.TecMatch.repository.PiezaEnListaConstruccionRepository;
import com.tecMatch.TecMatch.repository.PiezaRepository;
import com.tecMatch.TecMatch.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PiezaEnListaConstruccionServiceImpl implements PiezaEnListaConstruccionService{
    private final PiezaEnListaConstruccionMapper piezaEnListaConstruccionMapper;
    private final PiezaEnListaConstruccionRepository piezaEnListaConstruccionRepository;
    private final PiezaRepository piezaRepository;
    private final UsuarioRepository usuarioRepository;
    public PiezaEnListaConstruccionServiceImpl(PiezaEnListaConstruccionMapper piezaEnListaConstruccionMapper,PiezaEnListaConstruccionRepository piezaEnListaConstruccionRepository,
                                               PiezaRepository piezaRepository, UsuarioRepository usuarioRepository){
        this.piezaEnListaConstruccionMapper = piezaEnListaConstruccionMapper;
        this.piezaEnListaConstruccionRepository = piezaEnListaConstruccionRepository;
        this.piezaRepository = piezaRepository;
        this.usuarioRepository= usuarioRepository;
    }

    @Override
    public PiezaEnListaConstruccionDto save(PiezaEnListaConstruccionToSaveDto piezaEnListaConstruccionToSaveDto) {
        Usuario usuarioFound = usuarioRepository.findById(piezaEnListaConstruccionToSaveDto.usuario().id())
                .orElseThrow(()->new RuntimeException("Usuario no fue encontrado"));
        Pieza piezaFound = piezaRepository.findById(piezaEnListaConstruccionToSaveDto.pieza().id())
                .orElseThrow(()->new RuntimeException("Pieza no fue encontrada"));
        PiezaEnListaConstruccion piezaToSave = piezaEnListaConstruccionMapper.ToSaveDtoToEntity(piezaEnListaConstruccionToSaveDto);
        piezaToSave.setPieza(piezaFound);
        piezaToSave.setUsuario(usuarioFound);
        PiezaEnListaConstruccion piezaEnListaConstruccionSaved = piezaEnListaConstruccionRepository.save(piezaToSave);
        return piezaEnListaConstruccionMapper.EntityToDto(piezaEnListaConstruccionSaved);
    }

    @Override
    public List<PiezaEnListaConstruccionDto> findByUsuarioId(UUID idUsuario) {
        List<PiezaEnListaConstruccion> piezaEnListaConstruccionFound = piezaEnListaConstruccionRepository.findByUsuarioId(idUsuario);
        return piezaEnListaConstruccionFound.stream().parallel().map(piezaEnListaConstruccionMapper::EntityToDto).toList();
    }

    @Override
    public void delete(UUID idToDelete) {
        PiezaEnListaConstruccion piezaEnListaConstruccionFound = piezaEnListaConstruccionRepository.findById(idToDelete)
                .orElseThrow(()->new RuntimeException("Pieza en Lista de deseados no fue encontrada"));
        piezaEnListaConstruccionRepository.delete(piezaEnListaConstruccionFound);
    }

}
