package com.example.advquerying.services;
import java.util.List;
import java.util.Set;

public interface IngredientService {

    List<String> findIngredientsWhichNameStartsWithLetters(String letters);

    List<String> findIngredientsIngredientsByNames(Set<String> ingredients);
}
