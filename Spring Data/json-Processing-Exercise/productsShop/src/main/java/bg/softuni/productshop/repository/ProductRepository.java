package bg.softuni.productshop.repository;


import bg.softuni.productshop.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Set<Product> findAllByPriceBetweenAndBuyerIsNullOrderByPriceDesc(BigDecimal min, BigDecimal max);
}
