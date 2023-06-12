package com.example.json.config;


import com.example.json.model.dto.UsersAndProductsDto;
import com.example.json.model.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();

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
