package com.example.carDealer.service;

import com.example.carDealer.excetption.UnableToConvertException;
import com.example.carDealer.model.dto.CarDto;
import com.example.carDealer.model.dto.CarInfoDto;
import com.example.carDealer.model.dto.CarSeedDto;
import com.example.carDealer.model.dto.CarsSeedDto;
import com.example.carDealer.model.entity.Car;
import com.example.carDealer.model.entity.Part;
import com.example.carDealer.repository.CarRepository;
import com.example.carDealer.util.FormatConverter;
import com.example.carDealer.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.carDealer.constans.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class CarServiceImpl implements CarService {
    private static final String FILENAME = "cars.";

    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;
    private final PartService partService;
    private final CarRepository carRepository;

    public CarServiceImpl(ModelMapper mapper, ValidationUtil validationUtil, PartService partService, CarRepository carRepository) {

        this.mapper = mapper;
        this.validationUtil = validationUtil;
        this.partService = partService;
        this.carRepository = carRepository;
    }


    @Override
    public Car findRandomCar() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, carRepository.count() + 1);

        return carRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public List<CarDto> carsFromMake(String make) {
        return carRepository.findByMakeEqualsOrderByModelAscTravelledDistanceDesc(make).stream()
                .map(car -> mapper.map(car, CarDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<CarInfoDto> carsWithParts() {
        return carRepository.findAll().stream()
                .map(car -> mapper.map(car, CarInfoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void seedCarsFromJSON(FormatConverter converter, String typeFormat) throws UnableToConvertException {
        if (carRepository.count() == 0) {
            List<CarSeedDto> seedDtoList = Arrays.stream(converter.deserializeFromFile(RESOURCES_FILE_PATH + FILENAME + typeFormat, CarSeedDto[].class))
                    .toList();
            seedDto(seedDtoList);


        }

    }


    @Override
    public void seedCarsFromXML(FormatConverter converter, String typeFormat) throws UnableToConvertException {
        if (carRepository.count() == 0) {
            CarsSeedDto carsSeedDto = converter.deserializeFromFile(RESOURCES_FILE_PATH + FILENAME + typeFormat, CarsSeedDto.class);
            seedDto(carsSeedDto.getCars());
        }
    }

    private void seedDto(List<CarSeedDto> seedDtoList) {
        seedDtoList.stream()
                .filter(validationUtil::isValid)
                .map(carSeedDto -> {
                    Car car = mapper.map(carSeedDto, Car.class);
                    Set<Part> partSet = partService.randomSetOfParts();
                    car.setParts(partSet);
                    return car;
                }).forEach(carRepository::saveAndFlush);
    }


}
