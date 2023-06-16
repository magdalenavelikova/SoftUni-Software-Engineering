package com.example.json.service;

import com.example.json.model.dto.ProductsInRangeDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void importProducts() throws IOException;

    List<ProductsInRangeDto> productsInRange(BigDecimal valueOf, BigDecimal valueOf1);
}
