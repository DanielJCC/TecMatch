package com.tecMatch.TecMatch.api;

import com.tecMatch.TecMatch.dto.review.ReviewDto;
import com.tecMatch.TecMatch.dto.review.ReviewToSaveDto;
import com.tecMatch.TecMatch.service.review.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping()
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewToSaveDto reviewToSaveDto){
        ReviewDto reviewSaved = reviewService.save(reviewToSaveDto);
        return ResponseEntity.ok().body(reviewSaved);
    }

    @GetMapping()
    public ResponseEntity<List<ReviewDto>> findAllReviews(){
        List<ReviewDto> allReviews = reviewService.findAll();
        return ResponseEntity.ok().body(allReviews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> findReviewById(@PathVariable UUID id){
        try{
            ReviewDto reviewFound = reviewService.findById(id);
            return ResponseEntity.ok().body(reviewFound);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/pieza/{id}")
    public ResponseEntity<List<ReviewDto>> findReviewByPiezaId(@PathVariable UUID id){
        List<ReviewDto> reviewsFound = reviewService.findByPiezaId(id);
        return ResponseEntity.ok().body(reviewsFound);
    }
    @GetMapping("/pieza/{id}/calificacion-promedio")
    public ResponseEntity<Double> getCalificacionPromedio(@PathVariable UUID id){
        try {
            Double reviewsFound = reviewService.getPromedioCalificaciones(id);
            return ResponseEntity.ok().body(reviewsFound);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable UUID id){
        try {
            reviewService.delete(id);
            return ResponseEntity.ok().body("Review con id " + id + " eliminada correctamente");
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
