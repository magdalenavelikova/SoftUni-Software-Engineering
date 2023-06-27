package com.example.carDealer.service;

import com.example.carDealer.excetption.UnableToConvertException;
import com.example.carDealer.model.dto.SupplierDto;
import com.example.carDealer.model.entity.Supplier;
import com.example.carDealer.util.FormatConverter;

import java.io.IOException;
import java.util.List;

public interface SupplierService {

    Supplier findRandomSupplier();

    List<SupplierDto> localSuppliers();

    void seedSuppliersFromJSON(FormatConverter converter, String typeFormat) throws UnableToConvertException;

    void seedSuppliersFromXML(FormatConverter converter, String typeFormat) throws UnableToConvertException;
}
