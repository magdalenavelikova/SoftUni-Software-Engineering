package com.example.json.repository;

import com.example.json.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Set<Product> findAllByPriceBetweenAndBuyerIsNullOrderByPriceDesc(BigDecimal min, BigDecimal max);
}
