package testmodelmapper.ModelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import testmodelmapper.DTO.ProductDTO;
import testmodelmapper.Entity.ProductEntity;

@Component
public class ProductMapper {

	private final ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDTO mapToDTO(ProductEntity entity) {
    	ProductDTO productDTO =  modelMapper.map(entity, ProductDTO.class);
        return productDTO;
    }

    public ProductEntity mapToEntity(ProductDTO dto) {
    	ProductEntity entity =  modelMapper.map(dto, ProductEntity.class);
        return entity;
    }
    
    public ProductEntity ToEntity(ProductDTO dto) {
    	ProductEntity entity = new ProductEntity();
    	entity.setProductName(dto.getProductName());
    	entity.setPrice(dto.getPrice());
    	entity.setMoTa(dto.getMoTa());
    	entity.setDateOrder(dto.getDateOrder());
    	entity.setQty(dto.getQty());
    	return entity;
    }
}
