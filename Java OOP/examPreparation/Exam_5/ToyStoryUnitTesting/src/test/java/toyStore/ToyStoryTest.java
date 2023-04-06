package toyStore;


import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ToyStoryTest {
    ToyStore toyStore;
    List<Toy> toys;

    @Before
    public void setup() throws OperationNotSupportedException {
        toyStore = new ToyStore();
        toys = List.of(
                new Toy("Lego", "1"),
                new Toy("Barby", "2"),
                new Toy("Fishbone", "3")
        );
        String output = toyStore.addToy("A", toys.get(0));
    }

    @Test
    public void testConstructor() {
        toyStore = new ToyStore();
        Map<String, Toy> toyShelf = toyStore.getToyShelf();
        assertEquals(7, toyShelf.size());
    }

    @Test
    public void testAddToyShouldAddToyOnShelfA() {

        Toy actual = toyStore.getToyShelf().get("A");
        assertEquals(toys.get(0).getToyId(), actual.getToyId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyToNonexistentShelfShouldThrowEx() throws OperationNotSupportedException {
        toyStore.addToy("W", toys.get(0));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyToSameShelfShouldThrowEx() throws OperationNotSupportedException {

        toyStore.addToy("A", toys.get(1));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddSameToyShouldThrowExOp() throws OperationNotSupportedException {

        toyStore.addToy("B", toys.get(0));
    }

    @Test
    public void testRemoveToyShouldRemoveToyOnShelfA() {

        Toy toy = toyStore.getToyShelf().get("A");
        String output = toyStore.removeToy("A", toy);
        assertFalse(toyStore.getToyShelf().containsValue(toy));
        assertTrue(toyStore.getToyShelf().containsValue(null));
        assertEquals("Remove toy:1 successfully!", output);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyFromNonexistentShelfShouldThrowEx() {

        Toy toy = toyStore.getToyShelf().get("A");
        toyStore.removeToy("W", toy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonexistentToyShouldThrowEx() {
                toyStore.removeToy("A", toys.get(1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetToyShelfShouldThrowExBecauseReturnUnmodifiableList() {
        toyStore.getToyShelf().put("A", toys.get(0));
    }

}