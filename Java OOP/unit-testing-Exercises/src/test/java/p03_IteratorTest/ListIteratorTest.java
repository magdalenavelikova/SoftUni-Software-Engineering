package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator listIterator;
    private static final String[] NAMES = {"Alex", "John", "Antony"};

    @Before
    public void prepare() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCreateShouldThrowWhenIsEmptyList() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

    @Test
    public void testCreate() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
        String[] array = new String[NAMES.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = listIterator.print();
            listIterator.move();
        }
        assertArrayEquals(NAMES, array);
    }

    @Test
    public void testMove() {
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test
    public void testHasNext() {
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void testPrint() {
        assertEquals (NAMES[0],listIterator.print());
        listIterator.move();
        assertEquals (NAMES[1],listIterator.print());
        listIterator.move();
        assertEquals (NAMES[2],listIterator.print());

    }
    @Test(expected = IllegalStateException.class)
    public void testPrintShouldThrowWhenIsEmpty () throws OperationNotSupportedException {
       ListIterator emptyListIterator=new ListIterator();
        emptyListIterator.print();

    }
}