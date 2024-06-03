package com.tecMatch.TecMatch.service.review;

import com.tecMatch.TecMatch.dto.review.ReviewDto;
import com.tecMatch.TecMatch.dto.review.ReviewToSaveDto;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    ReviewDto save(ReviewToSaveDto reviewToSaveDto);
    List<ReviewDto> findAll();
    ReviewDto findById(UUID idToFind);
    Double getPromedioCalificaciones(UUID idPieza);
    List<ReviewDto> findByPiezaId(UUID idPieza);
    ReviewDto update(UUID idToUpdate, ReviewToSaveDto reviewToSaveDto);
    void delete(UUID idToDelete);
}
