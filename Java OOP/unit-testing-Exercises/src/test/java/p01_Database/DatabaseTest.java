package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    private Database database;
    private static final Integer[] ARRAY = {1, 2, 5, 6};

    @Before
    public void prepare() throws OperationNotSupportedException {
        database = new Database(ARRAY);
    }

    @Test
    public void testConstructorCreateValidDataBase() {
        assertArrayEquals(ARRAY, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWhenCreateEmptyDataBase() throws OperationNotSupportedException {
        Integer[] emptyArr = new Integer[0];
        database = new Database(emptyArr);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWhenCreateBiggerThen16Database() throws OperationNotSupportedException {
        Integer[] bigArr = new Integer[17];
        database = new Database(bigArr);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testShouldThrowWhenAddNullToDatabase() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testShouldAddElementToDatabase() throws OperationNotSupportedException {
        database.add(5);
        Integer[] elements = database.getElements();
        assertEquals(elements[elements.length - 1], Integer.valueOf(5));
        assertEquals(elements.length, ARRAY.length + 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWhenRemoveFromEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < ARRAY.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveFromDatabase() throws OperationNotSupportedException {
        Integer[] elementsBeforeRemove = database.getElements();
        database.remove();
        Integer[] elementsAfterRemove = database.getElements();
        assertEquals(elementsBeforeRemove.length - 1, elementsAfterRemove.length);
        assertEquals(elementsBeforeRemove[elementsBeforeRemove.length - 2], elementsAfterRemove[elementsAfterRemove.length - 1]);
    }


}