package testmodelmapper.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testmodelmapper.Entity.ReviewEntity;
import testmodelmapper.Entity.UserEntity;
@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
	 // Custom query to find products by color
    List<ReviewEntity> findByUser(UserEntity user );

    // Custom query to find products by review
    List<ReviewEntity> findByDate(Date date);

    // Custom query to find products by name
    List<ReviewEntity> findByReviewStatus(Boolean reviewStatus);

    // Custom query to find product by ID
    Optional<ReviewEntity> findById(Long id);

    // Custom query to delete product by ID
    void deleteById(Long id);

    // Custom query to update product
    ReviewEntity saveAndFlush(ReviewEntity productEntity);
}
