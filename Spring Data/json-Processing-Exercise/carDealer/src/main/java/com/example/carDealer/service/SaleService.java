package com.example.carDealer.service;

import com.example.carDealer.model.dto.SaleDto;

import java.util.List;

public interface SaleService {
    void seedSales();

   List<SaleDto> salesWithAppliedDiscount();
}
