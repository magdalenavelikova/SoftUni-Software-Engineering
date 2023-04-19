package carShop;


import org.junit.Before;
import org.junit.Test;


import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class CarShopTests {
    private List<Car> cars;
    private CarShop carShop;
    private Car car;

    @Before
    public void setup() {
        carShop = new CarShop();
        cars = List.of(
                new Car("Opel", 100, 5000),
                new Car("Toyota", 200, 10000),
                new Car("VW", 300, 50000)
        );
        car = new Car("Test", 1, 1);
        cars.stream().forEach(c -> carShop.add(c));
    }

    @Test
    public void testConstructor() {
        assertEquals(cars.size(), carShop.getCount());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetCarsShouldThrowExBecauseReturnUnmodifiableList() {
        carShop.getCars().add(car);
    }

    @Test
    public void testGetCarsShouldReturnUnmodifiableList() {
        List<Car> actual = carShop.getCars();
        assertEquals(cars, actual);
    }

    @Test
    public void testFindAllCarsWithMaxHorsePowerShouldReturnCarWithBiggerPower() {
        List<Car> expected = cars.stream().filter(c -> c.getHorsePower() > 200).collect(Collectors.toList());
        List<Car> actual = carShop.findAllCarsWithMaxHorsePower(200);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void testAddCarShouldThrowWhenCarIsNull() {
        carShop.add(null);
    }

    @Test
    public void testRemoveCarShouldReturnFalse() {
        boolean actual = carShop.remove(car);
        assertFalse(actual);
    }

    @Test
    public void testRemoveCarShouldReturnTrue() {
        carShop.add(car);
        boolean actual = carShop.remove(car);
        assertTrue(actual);
        int size = carShop.getCount();
        assertEquals(cars.size(), size);
    }

    @Test
    public void testGetTheMostLuxuryCarShouldReturnCar() {
        Car expected = cars.stream()
                .sorted((c1, c2) -> Double.compare(c2.getPrice(), c1.getPrice()))
                .limit(1)
                .findFirst()
                .orElse(null);

        Car actual = carShop.getTheMostLuxuryCar();
        assertEquals(expected.getModel(), actual.getModel());
    }

    @Test
    public void testGetTheMostLuxuryCarShouldReturnNull() {
        cars.stream().forEach(c -> carShop.remove(c));

        Car actual = carShop.getTheMostLuxuryCar();
        assertNull(actual);
    }

    @Test
    public void testFindAllCarByModelShouldReturnList() {
        List<Car> expected = cars.stream().filter(c -> c.getModel().equals("VW")).collect(Collectors.toList());
        List<Car> actual = carShop.findAllCarByModel("VW");
        assertEquals(expected, actual);
        assertEquals(expected.size(), actual.size());
    }
}

