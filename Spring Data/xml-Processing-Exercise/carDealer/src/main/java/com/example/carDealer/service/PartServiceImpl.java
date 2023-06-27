package com.example.carDealer.service;

import com.example.carDealer.excetption.UnableToConvertException;
import com.example.carDealer.model.dto.PartSeedDto;
import com.example.carDealer.model.dto.PartsSeedDto;
import com.example.carDealer.model.entity.Part;
import com.example.carDealer.repository.PartRepository;
import com.example.carDealer.util.FormatConverter;
import com.example.carDealer.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collector;

import static com.example.carDealer.constans.GlobalConstants.RESOURCES_FILE_PATH;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

@Service
public class PartServiceImpl implements PartService {
    private static final String FILENAME = "parts.";

    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;
    private final PartRepository partRepository;
    private final SupplierService supplierService;

    public PartServiceImpl(ModelMapper mapper, ValidationUtil validationUtil, PartRepository partRepository, SupplierService supplierService) {
        this.mapper = mapper;
        this.validationUtil = validationUtil;
        this.partRepository = partRepository;
        this.supplierService = supplierService;
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

    @Override
    public void seedPartsFromJSON(FormatConverter converter, String typeFormat) throws UnableToConvertException {
        if (partRepository.count() == 0) {

            List<PartSeedDto> seedDtoList = stream(converter.deserializeFromFile(
                    RESOURCES_FILE_PATH + FILENAME + typeFormat, PartSeedDto[].class))
                    .toList();


            seedDto(seedDtoList);

        }
    }



    @Override
    public void seedPartsFromXML(FormatConverter converter, String typeFormat) throws UnableToConvertException {
        if (partRepository.count() == 0) {
            PartsSeedDto partsSeedDto = converter.deserializeFromFile(
                    RESOURCES_FILE_PATH + FILENAME + typeFormat, PartsSeedDto.class);
            seedDto(partsSeedDto.getParts());
        }
    }

    private void seedDto(List<PartSeedDto> seedDtoList) {
        seedDtoList.stream()
                .filter(validationUtil::isValid)
                .map(partSeedDto -> {
                    Part part = mapper.map(partSeedDto, Part.class);
                    part.setSupplier(supplierService.findRandomSupplier());
                    return part;

                })
                .forEach(partRepository::save);
    }


}
