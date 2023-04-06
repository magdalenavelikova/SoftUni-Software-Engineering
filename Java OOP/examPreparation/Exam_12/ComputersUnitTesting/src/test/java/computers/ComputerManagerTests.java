package computers;


import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.*;

public class ComputerManagerTests {
    private ComputerManager computerManager;
    private Computer computer;
    private List<Computer> computers;

    @Before
    public void setup() {
        computerManager = new ComputerManager();
        computer = new Computer("Test", "010", 5);
        computers = List.of(
                new Computer("Dell", "100", 100),
                new Computer("Asus", "101", 50),
                new Computer("HP", "102", 200)
        );
        computers.forEach(c -> computerManager.addComputer(c));
    }

    @Test
    public void testConstructor() {
        int size = computerManager.getCount();
        assertEquals(computers.size(), size);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetComputersShouldThrowExBecauseReturnUnmodifiableCollection() {
        computerManager.getComputers().add(computer);
    }

    @Test
    public void testGetComputersShouldReturnCollection() {
        List<Computer> actual = computerManager.getComputers();
        assertEquals(computers.size(), actual.size());
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(computers.get(i).getManufacturer(), actual.get(i).getManufacturer());
        }
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldThrowExBecauseComputerExist() {
        computerManager.addComputer(computers.get(0));
    }
   
    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldThrowExBecauseComputerIsNull() {
        computerManager.addComputer(null );
    }
    @Test
    public void testAddComputerShouldAddComputer() {
        computerManager.addComputer(computer);
        assertEquals(computer, computerManager.getComputers().get(computerManager.getCount() - 1));
    }

    @Test
    public void testRemoveComputerShouldAddComputer() {
        Computer actual = computerManager.removeComputer(computers.get(0).getManufacturer(), computers.get(0).getModel());
        assertEquals(computers.get(0), actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldThrowExBecauseComputerNotExist() {
        computerManager.getComputer("Invalid", "Invalid");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldThrowExBecauseManufacturerIsNull() {
        computerManager.getComputer(null, "Invalid");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldThrowExBecauseModelIsNull() {
        computerManager.getComputer("Invalid",null );
    }
    @Test
    public void testGetComputerShouldReturnComputer() {
        Computer actual = computerManager.getComputer(computers.get(0).getManufacturer(), computers.get(0).getModel());
        assertEquals(computers.get(0), actual);
    }

    @Test
    public void testGetComputersByManufacturerShouldReturnList() {
        List<Computer> expected = computers.stream()
                .filter(c -> c.getManufacturer().equals("Asus"))
                .collect(Collectors.toList());

        List<Computer> actual = computerManager.getComputersByManufacturer("Asus");
        assertEquals(expected, actual);
        assertEquals(expected.size(), actual.size());

    }

    @Test
    public void testGetComputersByManufacturerShouldReturnEmptyList() {
        List<Computer> actual = computerManager.getComputersByManufacturer("Invalid");
        assertEquals(0, actual.size());
    }


}