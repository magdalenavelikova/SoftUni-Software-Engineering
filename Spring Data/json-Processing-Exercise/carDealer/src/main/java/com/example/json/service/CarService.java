package com.example.json.service;

import com.example.json.model.dto.CarDto;
import com.example.json.model.dto.CarInfoDto;

import com.example.json.model.entity.Car;

import java.io.IOException;
import java.util.List;

public interface CarService {
    void seedCars() throws IOException;
    Car findRandomCar();

    List<CarDto> carsFromMake(String make);

    List<CarInfoDto> carsWithParts();
}
