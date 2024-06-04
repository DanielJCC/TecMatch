package com.tecMatch.TecMatch.service.review;

import com.tecMatch.TecMatch.dto.review.ReviewDto;
import com.tecMatch.TecMatch.dto.review.ReviewToSaveDto;
import com.tecMatch.TecMatch.entities.Pieza;
import com.tecMatch.TecMatch.entities.Review;
import com.tecMatch.TecMatch.entities.Usuario;
import com.tecMatch.TecMatch.mappers.ReviewMapper;
import com.tecMatch.TecMatch.repository.PiezaRepository;
import com.tecMatch.TecMatch.repository.ReviewRepository;
import com.tecMatch.TecMatch.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReviewServiceImpl implements ReviewService{
    private final ReviewMapper reviewMapper;
    private final ReviewRepository reviewRepository;
    private final PiezaRepository piezaRepository;
    private final UsuarioRepository usuarioRepository;
    public ReviewServiceImpl(ReviewMapper reviewMapper, ReviewRepository reviewRepository,
                             PiezaRepository piezaRepository, UsuarioRepository usuarioRepository){
        this.reviewMapper = reviewMapper;
        this.reviewRepository = reviewRepository;
        this.piezaRepository = piezaRepository;
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public ReviewDto save(ReviewToSaveDto reviewToSaveDto) {
        Pieza piezaFound = piezaRepository.findById(reviewToSaveDto.pieza().id())
                .orElseThrow(() -> new RuntimeException("Pieza no encontrada"));
        Usuario usuarioFound = usuarioRepository.findById(reviewToSaveDto.usuario().id())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Review reviewToSave = reviewMapper.ToSaveDtoToEntity(reviewToSaveDto);
        reviewToSave.setUsuario(usuarioFound);
        reviewToSave.setPieza(piezaFound);
        Review reviewSaved = reviewRepository.save(reviewToSave);
        return reviewMapper.EntityToDto(reviewSaved);
    }

    @Override
    public List<ReviewDto> findAll() {
        List<Review> allReviews = reviewRepository.findAll();
        return allReviews.stream().parallel().map(reviewMapper::EntityToDto).toList();
    }

    @Override
    public ReviewDto findById(UUID idToFind) {
        Review reviewFound = reviewRepository.findById(idToFind)
                .orElseThrow(() -> new RuntimeException("Review no encontrada"));
        return reviewMapper.EntityToDto(reviewFound);
    }

    @Override
    public Double getPromedioCalificaciones(UUID idPieza) {
        return reviewRepository.getPromedioCalificacionesByPiezaId(idPieza)
                .orElseThrow(() -> new RuntimeException("Pieza no encontrada"));
    }

    @Override
    public List<ReviewDto> findByPiezaId(UUID idPieza) {
        List<Review> reviewsFound = reviewRepository.findByPiezaId(idPieza);
        return reviewsFound.stream().parallel().map(reviewMapper::EntityToDto).toList();
    }

    @Override
    public ReviewDto update(UUID idToUpdate, ReviewToSaveDto reviewToSaveDto) {
        Review reviewFound = reviewRepository.findById(idToUpdate)
                .orElseThrow(() -> new RuntimeException("Review no encontrada"));
        reviewMapper.updateReviewFromToSaveDto(reviewToSaveDto,reviewFound);
        Review reviewUpdated = reviewRepository.save(reviewFound);
        return reviewMapper.EntityToDto(reviewUpdated);
    }

    @Override
    public void delete(UUID idToDelete) {
        Review reviewFound = reviewRepository.findById(idToDelete)
                .orElseThrow(() -> new RuntimeException("Review no encontrada"));
        reviewRepository.delete(reviewFound);
    }

}
