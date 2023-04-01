package christmasRaces.entities.races;

import christmasRaces.entities.drivers.Driver;

import java.util.Collection;

public interface Race {
    String getName();

    int getLaps();

    Collection<Driver> getDrivers();

    void addDriver(Driver driver);
}
