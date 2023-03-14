package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ExcavationTests {
    private List<Archaeologist> archaeologists;
    private Excavation excavation;

    @Before
    public void setup() {
        archaeologists = List.of(
                new Archaeologist("Alex", 50),
                new Archaeologist("Ivan", 20),
                new Archaeologist("Stefan", 30)
        );
        excavation = new Excavation("New", 4);
        archaeologists.forEach(excavation::addArchaeologist);

    }

    @Test
    public void testConstructor() {
        excavation = new Excavation("Empty", 4);
        assertEquals(4, excavation.getCapacity());
        assertEquals("Empty", excavation.getName());
        assertEquals(0, excavation.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowExWhenNameIsNull() {
        excavation = new Excavation(null, 50);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowExWhenNameIsEmptyString() {
        excavation = new Excavation(" ", 50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowExWhenCapacityIsNegative() {
        excavation = new Excavation("Test", -2);
    }

    @Test
    public void testGetCountShouldReturnCollectionSize() {
        Assert.assertEquals(3, excavation.getCount());
    }

    @Test
    public void testGetNameShouldReturnName() {
        String expected = "New";
        String actual = excavation.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCapacityShouldReturnCapacity() {
        assertEquals(4, excavation.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistShouldThrowExWhenArchaeologistExist() {
        excavation.addArchaeologist(archaeologists.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistShouldThrowExWhenCapacityIsFull() {
        excavation = new Excavation("Test", 0);
        Archaeologist archaeologist = new Archaeologist("Petkan", 50);
        excavation.addArchaeologist(archaeologist);

    }

    @Test
    public void testAddArchaeologistShouldAdd() {
        Archaeologist archaeologist = new Archaeologist("Petkan", 50);
        excavation.addArchaeologist(archaeologist);
        assertEquals(4, excavation.getCount());

    }

    @Test
    public void testRemoveArchaeologistShouldRemove() {

        assertTrue(excavation.removeArchaeologist("Alex"));
        assertEquals(2, excavation.getCount());
    }

    @Test
    public void testRemoveArchaeologistShouldNotRemove() {
        assertFalse(excavation.removeArchaeologist("Me"));

        assertEquals(3, excavation.getCount());
    }

}
