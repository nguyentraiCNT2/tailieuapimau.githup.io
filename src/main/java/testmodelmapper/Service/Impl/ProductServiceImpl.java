package testmodelmapper.Service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testmodelmapper.DTO.ProductDTO;
import testmodelmapper.Entity.ProductEntity;
import testmodelmapper.ModelMapper.ProductMapper;
import testmodelmapper.Repository.ProductRepository;
import testmodelmapper.Service.ProductService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    private final ProductMapper productMapper;
    
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }
    
    @Override
    public ProductDTO getProductById(Long id) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return modelMapper.map(productEntity, ProductDTO.class);
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        if (productDTO != null) {
            ProductEntity productEntity = productMapper.ToEntity(productDTO);
            
            if (productEntity != null) {
                productRepository.save(productEntity);
            } else {
                // Xử lý trường hợp productEntity là null, có thể in log hoặc xử lý khác
                System.err.println("ProductEntity is null. Mapping may have failed.");
            }
        } else {
            // Xử lý trường hợp productDTO là null, có thể in log hoặc xử lý khác
            System.err.println("ProductDTO is null.");
        }
    }
    @Override
    public List<ProductDTO> getByProductName(String productName) {
        List<ProductEntity> products = productRepository.findByProductNameContaining(productName);
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public void updateProduct(ProductDTO productDTO) {
        Long productId = productDTO.getId();

        // Kiểm tra xem id có khác null không
        if (productId == null) {
            throw new RuntimeException("Product id is null");
        }

        // Kiểm tra xem sản phẩm có tồn tại không
        ProductEntity existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Không nên thay đổi ID trực tiếp
        // existingProduct.setId(newId);
        existingProduct =productMapper.mapToEntity(productDTO);
        existingProduct.setId(productId);
//        // Cập nhật thông tin từ DTO vào sản phẩm đã tìm thấy
//        existingProduct.setProductName(productDTO.getProductName());
//        existingProduct.setPrice(productDTO.getPrice());
//        existingProduct.setDateOrder(productDTO.getDateOrder());
//        // ... cập nhật các trường khác tùy theo nhu cầu của bạn

        // Lưu sản phẩm đã cập nhật vào cơ sở dữ liệu
        productRepository.save(existingProduct);
    }

    @Transactional
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }
}
