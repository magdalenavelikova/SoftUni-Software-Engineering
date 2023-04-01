package christmasRaces.core;

import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.BaseCar;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.CarRepository;
import christmasRaces.repositories.DriverRepository;
import christmasRaces.repositories.RaceRepository;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;
    private Repository<Driver> driverRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver driverObj = new DriverImpl(driver);
        if (driverRepository.getByName(driver) != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }
        driverRepository.add(driverObj);
        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        BaseCar car = null;
        if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
        } else if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);
        }
        if (carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }
        carRepository.add(car);
        return String.format(CAR_CREATED, car.getClass().getSimpleName(),model );

    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = driverRepository.getByName(driverName);
        Car car = carRepository.getByName(carModel);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        if (car == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }
        driver.addCar(car);
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = raceRepository.getByName(raceName);
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        race.addDriver(driver);
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);
        Map<Double, Driver> driverByRacePoints = new TreeMap<>();
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        int laps = race.getLaps();
        Collection<Driver> drivers = race.getDrivers().stream()
                .filter(d -> d.getCanParticipate() == true)
                .collect(Collectors.toList());

        if (drivers.size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        drivers.forEach(d -> driverByRacePoints.put(d.getCar().calculateRacePoints(laps), d));
        raceRepository.remove(race);
        StringBuilder sb = new StringBuilder();
        List<Driver> winners = driverByRacePoints.values().stream().limit(3).collect(Collectors.toList());

        sb.append(String.format(DRIVER_FIRST_POSITION, winners.get(2).getName(), raceName)).append(System.lineSeparator());
        sb.append(String.format(DRIVER_SECOND_POSITION, winners.get(1).getName(), raceName)).append(System.lineSeparator());
        sb.append(String.format(DRIVER_THIRD_POSITION, winners.get(0).getName(), raceName)).append(System.lineSeparator());


        return sb.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);
        if (raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        raceRepository.add(race);
        return String.format(RACE_CREATED, name);
    }
}
