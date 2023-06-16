package bg.softuni.productshop.config;


import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public GsonBuilder gsonBuilder() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation();


    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
//
//        TypeMap<Product, ProductsInRangeDto> typeMap = modelMapper.createTypeMap(Product.class, ProductsInRangeDto.class);
//        typeMap.addMappings(m -> m.map(src -> String.format("%s %S", src.getSeller().getFirstName(), src.getSeller().getLastName()),
//                ProductsInRangeDto::setSellerFullName));



        return modelMapper;
    }
}
