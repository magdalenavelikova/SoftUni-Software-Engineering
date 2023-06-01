package com.example.advquerying.services;

import com.example.advquerying.entities.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;


public interface ShampooService {
    List<String> findShampooByGivenSize(Size size);

    List<String> findShampoosBySizeOrLabel(Size size, long labelId);

    List<String> findShampoosWithPriceHigherThan(BigDecimal price);

    int findCountOfShampoosWithPriceLowerThan(BigDecimal price);

    List<String> findShampoosWithIngredients(Set<String> ingredients);

    List<String> findShampoosWithIngredientsLessThan(int count);
}
