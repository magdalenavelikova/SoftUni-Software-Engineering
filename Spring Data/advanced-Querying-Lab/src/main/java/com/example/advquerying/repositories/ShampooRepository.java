package com.example.advquerying.repositories;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo,Long> {

    List<Shampoo> findAllBySizeOrderById(Size size);
    List<Shampoo> findAllBySizeOrLabel_IdOrderByPrice(Size medium, Long labelId);
    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);
}
