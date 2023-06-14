package com.example.json.service;

import com.example.json.model.dto.PartSeedDto;
import com.example.json.model.entity.Part;
import com.example.json.repository.PartRepository;
import com.example.json.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.json.constans.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class PartServiceImpl implements PartService {
    private static final String FILENAME = "parts.json";
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;
    private final PartRepository partRepository;
    private final SupplierService supplierService;

    public PartServiceImpl(Gson gson, ModelMapper mapper, ValidationUtil validationUtil, PartRepository partRepository, SupplierService supplierService) {
        this.gson = gson;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
        this.partRepository = partRepository;
        this.supplierService = supplierService;
    }

    @Override
    public void seedParts() throws IOException {
        if (partRepository.count() == 0) {
            Arrays.stream(gson.fromJson(Files.readString(Path.of(
                            RESOURCES_FILE_PATH + FILENAME)), PartSeedDto[].class))
                    .toList()
                    .stream()
                    .filter(validationUtil::isValid)
                    .map(partSeedDto -> {
                        Part part = mapper.map(partSeedDto, Part.class);
                        part.setSupplier(supplierService.findRandomSupplier());
                        return part;

                    })
                    .forEach(partRepository::save);

        }
    }
@Override
    public Set<Part> randomSetOfParts() {
        Set<Part> partSet = new HashSet<>();
        int partCount = ThreadLocalRandom.current().nextInt(3, 5);
        long total = partRepository.count();
        for (int i = 0; i < partCount; i++) {
            long randomId = ThreadLocalRandom
                    .current().nextLong(1, total + 1);
            partSet.add(partRepository.findById(randomId).orElse(null));

        }

        return partSet;
    }


}
