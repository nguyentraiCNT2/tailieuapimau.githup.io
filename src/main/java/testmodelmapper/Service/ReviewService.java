package testmodelmapper.Service;

import java.util.List;

import testmodelmapper.DTO.ReviewDTO;

public interface ReviewService {
	  ReviewDTO getReviewById(Long id);

	    void createReview(ReviewDTO reviewDTO);

	    void updateReview( ReviewDTO reviewDTO);

	    void deleteReview(Long id);

	    List<ReviewDTO> getAllReviews();
}
