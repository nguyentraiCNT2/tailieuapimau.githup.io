package testmodelmapper.ModelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import testmodelmapper.DTO.ProductDTO;
import testmodelmapper.DTO.ReviewDTO;
import testmodelmapper.Entity.ProductEntity;
import testmodelmapper.Entity.ReviewEntity;
@Component
public class ReviewMapper {

	private final ModelMapper modelMapper;

    public ReviewMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public ReviewDTO mapToDTO(ReviewEntity entity) {
    	ReviewDTO dto = new ReviewDTO();
    	dto.setId(entity.getId());
    	dto.setContentReview(entity.getContentReview());
    	dto.setReviewSao(entity.getReviewSao());
    	dto.setReviewStatus(entity.isReviewStatus());
    	dto.setDate(entity.getDate());
    	dto.setProduct(entity.getProduct().getId());
    	return dto;
    }
    public ReviewEntity ToEntity(ReviewDTO dto) {
    	ReviewEntity entity = new ReviewEntity();
    	entity.setId(dto.getId());
    	entity.setContentReview(dto.getContentReview());
    	entity.setReviewSao(dto.getReviewSao());
    	entity.setReviewStatus(dto.isReviewStatus());
    	entity.setDate(dto.getDate());
    	return entity;
    }
}
