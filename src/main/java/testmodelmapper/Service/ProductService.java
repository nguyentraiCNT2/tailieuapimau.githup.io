package testmodelmapper.Service;
import java.util.List;

import testmodelmapper.DTO.ProductDTO;
import testmodelmapper.Entity.ProductEntity;

public interface ProductService {
    ProductDTO getProductById(Long id);

    void createProduct(ProductDTO productDTO);

    void updateProduct( ProductDTO productDTO);

    void deleteProduct(Long id);

    List<ProductDTO> getAllProducts();
    List<ProductDTO> getByProductName(String productName);
}
