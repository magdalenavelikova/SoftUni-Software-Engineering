package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ServiceTests {
    private Service service;
    private Robot robot;
    private List<Robot> robots;

    @Before
    public void setup() {
        service = new Service("Test", 5);
        robots = List.of(
                new Robot("Robot1"),
                new Robot("Robot2"),
                new Robot("Robot3")
        );
        robots.stream().forEach(r -> service.add(r));
        robot = new Robot("Test");
    }

    @Test
    public void testConstructor() {
        int actual = service.getCapacity();
        assertEquals(5, actual);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowExByEmptyName() {
        service = new Service("", 5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowExByNull() {
        service = new Service(null, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowExByNull() {
        service = new Service("Test", -1);
    }

    @Test
    public void testGetCountShouldThrowExByNull() {
        int actual = service.getCount();
        assertEquals(3, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRobotShouldThrowExBecauseIsFull() {

        robots.stream().forEach(r -> service.add(r));
    }

    @Test
    public void testName() {
        String actual = service.getName();
        assertEquals("Test", actual);
    }

    @Test
    public void testRemoveShouldRemove() {
        service.remove("Robot1");
        assertEquals(robots.size() - 1, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowExWhenIsNull() {
        service.remove("Invalid");
    }

    @Test
    public void testForSaleShouldSetRobot() {
        Robot robotForSale = service.forSale("Robot1");
        Assert.assertFalse(robotForSale.isReadyForSale());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForSaleShouldThrowWhenIsInvalid() {
           service.forSale("Invalid");
    }

    @Test
    public void testReport() {
              Assert.assertEquals("The robot Robot1, Robot2, Robot3 is in the service Test!", service.report());

    }

}
