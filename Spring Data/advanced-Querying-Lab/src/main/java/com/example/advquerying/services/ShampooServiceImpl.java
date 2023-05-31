package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<String> findShampooByGivenSize(Size size) {
        List<Shampoo> result = this.shampooRepository.findAllBySizeOrderById(size);
       return convertToString(result);
    }



    @Override
    public List<String> findShampoosBySizeOrLabel(Size size, long labelId) {
        List<Shampoo> result = shampooRepository.findAllBySizeOrLabel_IdOrderByPrice(size, labelId);
        return convertToString(result);
    }

    @Override
    public List<String> findShampoosWithPriceHigherThen(BigDecimal price) {
        List<Shampoo> result = this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);
        return convertToString(result);
    }

    private List<String> convertToString(List<Shampoo> result) {
        return result
                .stream()
                .map(shampoo -> String.format("%s %s %.2flv.",
                        shampoo.getBrand(),
                        shampoo.getSize(),
                        shampoo.getPrice()))
                .collect(Collectors.toList());
    }
}
