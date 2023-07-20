package com.softuni.battleships.repositories;

import com.softuni.battleships.models.Category;
import com.softuni.battleships.models.ShipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(ShipType name);
}
