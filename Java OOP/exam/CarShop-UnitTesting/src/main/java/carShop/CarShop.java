package carShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarShop {

    private List<Car> cars;

    public CarShop() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public int getCount() {
        return this.cars.size();
    }

    public List<Car> findAllCarsWithMaxHorsePower(int horsePower) {
        List<Car> cars = this.cars.stream().filter(c -> c.getHorsePower() > horsePower).collect(Collectors.toList());

        return cars;
    }

    public void add(Car car) {
        if (car == null) {
            throw new NullPointerException("Car cannot be null.");
        }

        this.cars.add(car);
    }

    public boolean remove(Car car) {
        return this.cars.remove(car);
    }


    public Car getTheMostLuxuryCar() {
        Car car = this
                .cars
                .stream()
                .sorted((c1, c2) -> Double.compare(c2.getPrice(), c1.getPrice()))
                .limit(1)
                .findFirst()
                .orElse(null);

        return car;
    }

    public List<Car> findAllCarByModel(String model) {
        List<Car> cars = this.cars.stream().filter(c -> c.getModel().equals(model)).collect(Collectors.toList());

        return cars;
    }
}