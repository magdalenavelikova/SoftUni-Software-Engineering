package com.example.json.config;


import com.example.json.model.dto.ProductsBetweenPriceRangeWithoutBuyerDto;
import com.example.json.model.entity.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
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
//        TypeMap<Product, ProductsBetweenPriceRangeWithoutBuyerDto> typeMap = modelMapper.createTypeMap(Product.class, ProductsBetweenPriceRangeWithoutBuyerDto.class);
//        typeMap.addMappings(m -> m.map(src -> String.format("%s %S", src.getSeller().getFirstName(), src.getSeller().getLastName()),
//                ProductsBetweenPriceRangeWithoutBuyerDto::setSellerFullName));


        return modelMapper;
    }
}
