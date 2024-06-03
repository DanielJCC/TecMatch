package com.tecMatch.TecMatch.mappers;

import com.tecMatch.TecMatch.dto.review.ReviewDto;
import com.tecMatch.TecMatch.dto.review.ReviewToSaveDto;
import com.tecMatch.TecMatch.entities.Review;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review DtoToEntity(ReviewDto reviewDto);
    ReviewDto EntityToDto(Review review);
    Review ToSaveDtoToEntity(ReviewToSaveDto reviewToSaveDto);
}
