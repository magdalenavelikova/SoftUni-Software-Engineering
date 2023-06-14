package com.example.json.service;

import com.example.json.model.dto.CarDto;
import com.example.json.model.dto.CarInfoDto;
import com.example.json.model.dto.CarSeedDto;
import com.example.json.model.entity.Car;
import com.example.json.model.entity.Part;
import com.example.json.repository.CarRepository;
import com.example.json.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.json.constans.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class CarServiceImpl implements CarService {
    private static final String FILENAME = "cars.json";
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;
    private final PartService partService;
    private final CarRepository carRepository;

    public CarServiceImpl(Gson gson, ModelMapper mapper, ValidationUtil validationUtil, PartService partService, CarRepository carRepository) {
        this.gson = gson;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
        this.partService = partService;
        this.carRepository = carRepository;
    }


    @Override
    public void seedCars() throws IOException {
        if(carRepository.count()==0){
            Arrays.stream(gson.fromJson(Files.readString(Path.of(RESOURCES_FILE_PATH + FILENAME)), CarSeedDto[].class))
                    .toList()
                    .stream()
                    .filter(validationUtil::isValid)
                    .map(carSeedDto -> {
                        Car car = mapper.map(carSeedDto, Car.class);
                        Set<Part> partSet = partService.randomSetOfParts();
                        car.setParts(partSet);
                        return car;
                    }).forEach(carRepository::saveAndFlush);
        }

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
                .map(car->mapper.map(car, CarDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<CarInfoDto> carsWithParts() {
        return carRepository.findAll().stream()
                .map(car -> mapper.map(car,CarInfoDto.class))
                .collect(Collectors.toList());
    }
}
