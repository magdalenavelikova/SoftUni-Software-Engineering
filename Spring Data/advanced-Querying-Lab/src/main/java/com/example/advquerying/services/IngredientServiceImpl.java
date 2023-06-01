package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<String> findIngredientsWhichNameStartsWithLetters(String letters) {
        return ingredientRepository.findAllByNameIsStartingWith(letters)
                .stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());

    }

    @Override
    public List<String> findIngredientsIngredientsByNames(Set<String> ingredients) {
        return ingredientRepository.findAllByNameIsInOrderByPrice(ingredients)
                .stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteIngredient(String name) {

        if (!ingredientRepository.existsIngredientByName(name)) {
            System.out.println("No such Ingredient!");
            return;
        }
        ingredientRepository.deleteByName(name);
        System.out.println(name + " is delete");
    }

    @Override

    public void updateIngredientsPrice() {
        ingredientRepository.updateAllPrice();
    }

    @Override

    public void updateIngredientsPriceByName(String name) {
        ingredientRepository.updateAllPriceByName(name);
    }
}
