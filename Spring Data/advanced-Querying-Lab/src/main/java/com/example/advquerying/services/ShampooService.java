package com.example.advquerying.services;

import com.example.advquerying.entities.Size;

import java.math.BigDecimal;
import java.util.List;


public interface ShampooService {
    List<String> findShampooByGivenSize(Size size);

    List<String> findShampoosBySizeOrLabel(Size size, long labelId);

    List<String>  findShampoosWithPriceHigherThen(BigDecimal price);
}
