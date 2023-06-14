package com.example.json.service;

import com.example.json.model.dto.SupplierDto;
import com.example.json.model.dto.SupplierSeedDto;
import com.example.json.model.entity.Supplier;
import com.example.json.repository.SupplierRepository;
import com.example.json.util.ValidationUtil;
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

import static com.example.json.constans.GlobalConstants.RESOURCES_FILE_PATH;
@Service
public class SupplierServiceImpl implements SupplierService {
    private final ModelMapper mapper;
    private static final String FILENAME = "suppliers.json";
    private final SupplierRepository supplierRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public SupplierServiceImpl(ModelMapper mapper, SupplierRepository supplierRepository, Gson gson, ValidationUtil validationUtil) {
        this.mapper = mapper;
        this.supplierRepository = supplierRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedSuppliers() throws IOException {
        if(supplierRepository.count()==0){
            Arrays.stream(
                            this.gson.fromJson(Files.readString(Path.of(
                                    RESOURCES_FILE_PATH + FILENAME)), SupplierSeedDto[].class)
                    )
                    .toList()
                    .stream()
                    .filter(validationUtil::isValid)
                    .map(supplierSeedDto -> mapper.map(supplierSeedDto, Supplier.class))
                    .forEach(supplierRepository::save);
        }
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
}
