package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    private Database database;
    private static final Person JOHN = new Person(1, "John");
    private static final Person STEVEN = new Person(2, "Steven");
    private static final Person ALEX = new Person(3, "Alex");
    private static final Person[] ARRAY = {JOHN, STEVEN, ALEX};


    @Before
    public void prepare() throws OperationNotSupportedException {
        database = new Database(JOHN, STEVEN, ALEX);
    }

    @Test
    public void testConstructorCreateValidDataBase() {
        assertArrayEquals(ARRAY, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWhenCreateEmptyDataBase() throws OperationNotSupportedException {
        Person[] emptyArr = new Person[0];
        database = new Database(emptyArr);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWhenCreateBiggerThen16Database() throws OperationNotSupportedException {
        Person[] bigArr = new Person[17];
        database = new Database(bigArr);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testShouldThrowWhenAddNullToDatabase() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testShouldAddElementToDatabase() throws OperationNotSupportedException {
        Person ivan = new Person(5, "Ivan");
        database.add(ivan);
        Person[] elements = database.getElements();
        assertEquals(elements[elements.length - 1], ivan);
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
        Person[] elementsBeforeRemove = database.getElements();
        database.remove();
        Person[] elementsAfterRemove = database.getElements();
        assertEquals(elementsBeforeRemove.length - 1, elementsAfterRemove.length);
        assertEquals(elementsBeforeRemove[elementsBeforeRemove.length - 2], elementsAfterRemove[elementsAfterRemove.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowWithNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowWithMissing() throws OperationNotSupportedException {
        database.findByUsername("Ivan");
    }

    @Test
    public void testFindByUsernameShouldReturn() throws OperationNotSupportedException {
        Person person = database.findByUsername(ALEX.getUsername());
        assertEquals(ALEX.getUsername(), person.getUsername());

    }

    @Test
    public void testFindByIdShouldReturn() throws OperationNotSupportedException {
        Person person = database.findById(ALEX.getId());
        assertEquals(ALEX.getId(), person.getId());

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdShouldThrowWithMissing() throws OperationNotSupportedException {
        database.findById(10);
    }

}