package testmodelmapper.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testmodelmapper.Entity.ColorEntity;
import testmodelmapper.Entity.ProductEntity;
import testmodelmapper.Entity.ReviewEntity;
import testmodelmapper.Entity.SizeEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	  // Custom query to find products by color
    List<ProductEntity> findByColor(ColorEntity color);

    // Custom query to find products by size
    List<ProductEntity> findBySize(SizeEntity size);


    // Custom query to find products by name
    List<ProductEntity> findByProductNameContaining(String productName);

    // Custom query to find product by ID
    Optional<ProductEntity> findById(Long id);

    // Custom query to delete product by ID
    void deleteById(Long id);

    // Custom query to update product
    ProductEntity saveAndFlush(ProductEntity productEntity);
}
