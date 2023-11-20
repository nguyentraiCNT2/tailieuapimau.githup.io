package testmodelmapper.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testmodelmapper.DTO.ProductDTO;
import testmodelmapper.DTO.ReviewDTO;
import testmodelmapper.Entity.ProductEntity;
import testmodelmapper.Entity.ReviewEntity;
import testmodelmapper.ModelMapper.ProductMapper;
import testmodelmapper.ModelMapper.ReviewMapper;
import testmodelmapper.Repository.ProductRepository;
import testmodelmapper.Repository.ReviewRepository;
import testmodelmapper.Service.ReviewService;
@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
    private ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, ReviewMapper reviewMapper, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
        this.productRepository = productRepository;
    }
    
    @Override
    public ReviewDTO getReviewById(Long id) {
        ReviewEntity reviewEntity = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        return modelMapper.map(reviewEntity, ReviewDTO.class);
    }

    @Override
    public void createReview(ReviewDTO reviewDTO) {
        if (reviewDTO != null) {
        	ProductEntity productEntity = new ProductEntity();
        	productEntity = productRepository.findById(reviewDTO.getProduct()).orElse(null);
        	ReviewEntity reviewEntity = new ReviewEntity();
        	 reviewEntity = reviewMapper.ToEntity(reviewDTO);
        	 reviewEntity.setProduct(productEntity);
            
            if (reviewEntity != null) {
            	reviewRepository.save(reviewEntity);
            } else {
                // Xử lý trường hợp productEntity là null, có thể in log hoặc xử lý khác
                System.err.println("ReviewEntity is null. Mapping may have failed.");
            }
        } else {
            // Xử lý trường hợp productDTO là null, có thể in log hoặc xử lý khác
            System.err.println("ReviewDTO is null.");
        }
    }

    @Override
    public void updateReview( ReviewDTO reviewDTO) {
    	ProductEntity productEntity = new ProductEntity();
    	productEntity = productRepository.findById(reviewDTO.getProduct()).orElse(null);
    	ReviewEntity reviewEntity = new ReviewEntity();
    	ReviewEntity existingReview = reviewRepository.findById(reviewDTO.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        modelMapper.map(reviewDTO, existingReview);
        reviewEntity.setProduct(productEntity);
        reviewRepository.save(existingReview);
    }
    @Transactional
    @Override
    public void deleteReview (Long id) {
    	reviewRepository.deleteById(id);
    }

    @Override
    public List<ReviewDTO> getAllReviews(){
        List<ReviewEntity> reviews = reviewRepository.findAll();
        return reviews.stream()
                .map(review -> reviewMapper.mapToDTO(review))
                .collect(Collectors.toList());
    }
}
