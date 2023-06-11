package com.example.json.service;

import com.example.json.model.dto.ProductsBetweenPriceRangeWithoutBuyerDto;
import com.example.json.model.entity.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ProductService {
    void importProducts() throws IOException;

    List<ProductsBetweenPriceRangeWithoutBuyerDto> productsInRange(BigDecimal valueOf, BigDecimal valueOf1);
}
