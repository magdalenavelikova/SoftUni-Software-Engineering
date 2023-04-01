package christmasRaces.core.interfaces;

import christmasRaces.entities.cars.Car;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.races.Race;
import christmasRaces.repositories.CarRepository;
import christmasRaces.repositories.DriverRepository;
import christmasRaces.repositories.RaceRepository;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;

public interface Controller {


    String createDriver(String driver);

    String createCar(String type, String model, int horsePower);

    String addCarToDriver(String driverName, String carModel);

    String addDriverToRace(String raceName, String driverName);

    String startRace(String raceName);

    String createRace(String name, int laps);
}
