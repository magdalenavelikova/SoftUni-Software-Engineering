package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {
    private CustomLinkedList<String> list;
    private int previousSize;

    @Before
    public void prepare() {
        list = new CustomLinkedList<>();
        list.add("Alex");
        list.add("Steve");
        list.add("Robert");
        previousSize = list.getCount();

    }

    @Test
    public void testAddShouldAdd() {

        list.add("Maggie");
        int currentSize = list.getCount();
        assertEquals(previousSize + 1, currentSize);
        assertEquals(list.get(currentSize - 1), "Maggie");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWhenInNegativeIndex() {
        list.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWhenIndexIBiggerThenSize() {
        list.get(list.getCount());
    }

    @Test
    public void testGetShouldGet() {
        String name = list.get(0);
        assertEquals("Alex", name);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetShouldThrowWhenInNegativeIndex() {
        list.set(-2, "Alan");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetShouldThrowWhenIndexIBiggerThenSize() {
        list.set(list.getCount() + 1, "Alan");
    }

    @Test
    public void testSetShouldSet() {
        String name = "Dan";
        list.set(list.getCount() - 1, name);
        assertEquals("Dan", list.get(list.getCount() - 1));
    }

    @Test
    public void testIndexOfShouldFind() {
        assertEquals(0, list.indexOf("Alex"));
    }

    @Test
    public void testIndexOfShouldNotFind() {
        assertEquals(-1, list.indexOf("Pesho"));
    }

    @Test
    public void testContainsShouldReturnTrue() {
        assertTrue(list.contains("Alex"));
    }

    @Test
    public void testContainsShouldReturnFalse() {
        assertFalse(list.contains("Petya"));
    }

    @Test
    public void testRemoveWithMissingElement() {
        assertEquals(-1, list.remove("Molly"));
    }

    @Test
    public void testRemoveShouldRemove() {
        assertEquals(0, list.remove("Alex"));
        int currentSize = list.getCount();
        assertEquals(-1, list.indexOf("Alex"));
        assertEquals(previousSize - 1, currentSize);
    }
    @Test
    public void testRemoveAtIndexShouldRemove() {
        assertEquals("Alex", list.removeAt(0));
        int currentSize = list.getCount();
        assertEquals(-1, list.indexOf("Alex"));
        assertEquals(previousSize - 1, currentSize);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtIndexShouldThrowWhenIndexIsInvalid() {
       list.removeAt(15);

    }

}