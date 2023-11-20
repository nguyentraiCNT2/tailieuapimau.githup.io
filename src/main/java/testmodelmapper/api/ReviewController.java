package testmodelmapper.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import testmodelmapper.DTO.ProductDTO;
import testmodelmapper.DTO.ReviewDTO;
import testmodelmapper.ModelMapper.ProductMapper;
import testmodelmapper.ModelMapper.ReviewMapper;
import testmodelmapper.Service.ProductService;
import testmodelmapper.Service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	 @Autowired
	    private ReviewService reviewService;
	    private final ReviewMapper reviewMapper;
	    
	    @Autowired
	    public ReviewController(ReviewService reviewService, ReviewMapper reviewMapper) {
	        this.reviewService = reviewService;
	        this.reviewMapper = reviewMapper;
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<?> getReviewById(@PathVariable Long id) {
	        try {
	           ReviewDTO reviewDTO = reviewService.getReviewById(id);
	            return new ResponseEntity<>(reviewDTO, HttpStatus.OK);
	        } catch (RuntimeException e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    }
	    @PostMapping
	    public ResponseEntity<String> createReview(@RequestBody ReviewDTO reviewDTO) {
	        try {
	        	reviewService.createReview(reviewDTO);
	            return new ResponseEntity<>("Review created successfully", HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	 
	    @PutMapping("/{id}")
	    public ResponseEntity<String> updateReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
	        try {
	        	reviewDTO.setId(id);
	        	reviewService.updateReview(reviewDTO);
	            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
	        } catch (RuntimeException e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	        } catch (Exception e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    @Transactional
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
	        try {
	        	reviewService.deleteReview(id);
	            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
	        } catch (RuntimeException e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	        } catch (Exception e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @GetMapping
	    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
	        try {
	            List<ReviewDTO> reviews = reviewService.getAllReviews();
	            return new ResponseEntity<>(reviews, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
}
