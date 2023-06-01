package com.example.advquerying.services;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface IngredientService {

    List<String> findIngredientsWhichNameStartsWithLetters(String letters);

    List<String> findIngredientsIngredientsByNames(Set<String> ingredients);

    @Transactional
    void deleteIngredient(String name);

    @Transactional
    void updateIngredientsPrice();

    @Transactional
    void updateIngredientsPriceByName(String name);
}
