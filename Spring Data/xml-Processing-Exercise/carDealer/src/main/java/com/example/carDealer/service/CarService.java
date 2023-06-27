package com.example.carDealer.service;

import com.example.carDealer.excetption.UnableToConvertException;
import com.example.carDealer.model.dto.CarDto;
import com.example.carDealer.model.dto.CarInfoDto;

import com.example.carDealer.model.entity.Car;
import com.example.carDealer.util.FormatConverter;

import java.io.IOException;
import java.util.List;

public interface CarService {

    Car findRandomCar();

    List<CarDto> carsFromMake(String make);

    List<CarInfoDto> carsWithParts();

    void seedCarsFromJSON(FormatConverter converter, String typeFormat) throws UnableToConvertException;

    void seedCarsFromXML(FormatConverter converter, String typeFormat) throws UnableToConvertException;
}
