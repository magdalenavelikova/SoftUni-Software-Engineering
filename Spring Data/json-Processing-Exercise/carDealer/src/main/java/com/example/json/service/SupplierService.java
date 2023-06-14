package com.example.json.service;

import com.example.json.model.dto.SupplierDto;
import com.example.json.model.dto.SupplierSeedDto;
import com.example.json.model.entity.Supplier;

import java.io.IOException;
import java.util.List;

public interface SupplierService {
    void seedSuppliers() throws IOException;
    Supplier findRandomSupplier();

    List<SupplierDto> localSuppliers();
}
