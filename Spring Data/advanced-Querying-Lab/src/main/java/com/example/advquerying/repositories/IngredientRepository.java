package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

    List<Ingredient> findAllByNameIsStartingWith(String letters);

    @Query("SELECT i FROM Ingredient i where i.name IN :ingredients order by i.price")
    List<Ingredient> findIngredientsIngredientsByNames(@Param(value = "ingredients") Set<String> stringSet);
}
