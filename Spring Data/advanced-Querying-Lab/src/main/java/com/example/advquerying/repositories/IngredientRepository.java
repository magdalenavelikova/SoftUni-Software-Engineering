package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAllByNameIsStartingWith(String letters);


    List<Ingredient> findAllByNameIsInOrderByPrice(Set<String> stringSet);

    boolean existsIngredientByName(String name);

    void deleteByName(String name);

    @Query("UPDATE Ingredient i SET i.price = i.price*1.10")
    @Modifying
    void updateAllPrice();

    @Query("UPDATE Ingredient i SET i.price = i.price*1.10 where i.name=:name")
    @Modifying
    void updateAllPriceByName(String name);
}
