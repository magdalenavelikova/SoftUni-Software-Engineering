package com.example.json.service;

import com.example.json.model.dto.SaleDto;

import java.util.List;

public interface SaleService {
    void seedSales();

   List<SaleDto> salesWithAppliedDiscount();
}
