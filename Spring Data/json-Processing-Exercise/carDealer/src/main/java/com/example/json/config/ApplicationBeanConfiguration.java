package com.example.json.config;


import com.example.json.model.dto.CustomerDto;
import com.example.json.model.dto.CustomerSeedDto;
import com.example.json.model.dto.SaleDto;
import com.example.json.model.entity.Customer;
import com.example.json.model.entity.Sale;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ofPattern;


@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public Gson gson() {
        return new GsonBuilder()
                //  .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();

    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<String, LocalDateTime> localDateConverter = mappingContext ->
                LocalDateTime.parse(mappingContext.getSource(), ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        Converter<LocalDateTime, String> fromLocalDateConverter = mappingContext -> mappingContext.getSource().toString();
        modelMapper.addConverter(localDateConverter);

        modelMapper.typeMap(CustomerSeedDto.class, Customer.class)
                .addMappings(mapper -> mapper.using(localDateConverter).map(CustomerSeedDto::getBirthDate, Customer::setBirthDate));

        modelMapper.typeMap(Customer.class, CustomerDto.class)
                .addMappings(mapper -> mapper.using(fromLocalDateConverter).map(Customer::getBirthDate, CustomerDto::setBirthDate));

        modelMapper.typeMap(Sale.class, SaleDto.class)
                .addMappings(mapper -> {
                    mapper.map(scr -> scr.getCustomer().getName(), SaleDto::setName);


//                    mapper.map(scr->scr.getCar().getParts().stream().map(Part::getPrice)
//                                   .reduce(BigDecimal.ZERO, BigDecimal::add),SaleDto::setPrice);

                });

        return modelMapper;
    }
}
