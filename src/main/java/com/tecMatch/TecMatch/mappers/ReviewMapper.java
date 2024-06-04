package com.tecMatch.TecMatch.mappers;

import com.tecMatch.TecMatch.dto.review.ReviewDto;
import com.tecMatch.TecMatch.dto.review.ReviewToSaveDto;
import com.tecMatch.TecMatch.entities.Review;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review DtoToEntity(ReviewDto reviewDto);
    ReviewDto EntityToDto(Review review);
    Review ToSaveDtoToEntity(ReviewToSaveDto reviewToSaveDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "pieza", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    void updateReviewFromToSaveDto(ReviewToSaveDto reviewToSaveDto, @MappingTarget Review review);
}
