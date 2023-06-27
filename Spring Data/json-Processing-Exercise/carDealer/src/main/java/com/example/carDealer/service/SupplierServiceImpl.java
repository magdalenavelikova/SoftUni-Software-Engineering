package com.example.carDealer.service;

import com.example.carDealer.excetption.UnableToConvertException;
import com.example.carDealer.model.dto.SupplierDto;
import com.example.carDealer.model.dto.SupplierSeedDto;
import com.example.carDealer.model.dto.SuppliersSeedDto;
import com.example.carDealer.model.entity.Supplier;
import com.example.carDealer.repository.SupplierRepository;
import com.example.carDealer.util.FormatConverter;
import com.example.carDealer.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.carDealer.constans.GlobalConstants.RESOURCES_FILE_PATH;
@Service
public class SupplierServiceImpl implements SupplierService {
    private final ModelMapper mapper;
    private static final String FILENAME = "suppliers.";
    private final SupplierRepository supplierRepository;
    private final ValidationUtil validationUtil;

    public SupplierServiceImpl(ModelMapper mapper, SupplierRepository supplierRepository,  ValidationUtil validationUtil) {
        this.mapper = mapper;
        this.supplierRepository = supplierRepository;
        this.validationUtil = validationUtil;
    }



    @Override
    public Supplier findRandomSupplier() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, supplierRepository.count() + 1);

        return supplierRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public List<SupplierDto> localSuppliers() {
     return    supplierRepository.findByIsImporterFalse().stream()
                .map(supplier -> {
                    SupplierDto supplierDto = mapper.map(supplier, SupplierDto.class);
                    supplierDto.setPartsCount(supplier.getParts().size());
                    return supplierDto;
                }).collect(Collectors.toList());


    }

    @Override
    public void seedSuppliersFromJSON(FormatConverter converter, String typeFormat) throws UnableToConvertException {
        if (supplierRepository.count() == 0) {
            List<SupplierSeedDto> seedDtoList = Arrays.stream(
                            converter.deserializeFromFile(RESOURCES_FILE_PATH + FILENAME + typeFormat,
                                    SupplierSeedDto[].class)
                    )
                    .toList();

            seedToDb(seedDtoList);
        }
    }



    @Override
    public void seedSuppliersFromXML(FormatConverter converter, String typeFormat) throws UnableToConvertException {
        if (supplierRepository.count() == 0) {
            SuppliersSeedDto suppliersSeedDto = converter.deserializeFromFile(RESOURCES_FILE_PATH + FILENAME + typeFormat, SuppliersSeedDto.class);

            seedToDb(suppliersSeedDto.getSupplierDtoList());

        }
    }

    private void seedToDb(List<SupplierSeedDto> seedDtoList) {
        seedDtoList.stream()
                .filter(validationUtil::isValid)
                .map(supplierSeedDto -> mapper.map(supplierSeedDto, Supplier.class))
                .forEach(supplierRepository::save);
    }
}
