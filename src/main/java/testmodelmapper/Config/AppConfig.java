package testmodelmapper.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import testmodelmapper.ModelMapper.ProductMapper;
import testmodelmapper.ModelMapper.ReviewMapper;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ProductMapper productMapper(ModelMapper modelMapper) {
        return new ProductMapper(modelMapper);
    }
    @Bean
    public ReviewMapper reiewMapper(ModelMapper modelMapper) {
        return new ReviewMapper(modelMapper);
    }
}
