package p02_ExtendedDatabase;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private Person[] elements;
    private int elementsCount;
    private int index;


    public Database(Person... people) throws OperationNotSupportedException {
        this.elementsCount = people.length;
        this.setElements(people);
        this.index = elementsCount - 1;
    }

    public void add(Person person) throws OperationNotSupportedException {
        if (person == null) {
            throw new OperationNotSupportedException();
        }

        this.elements[++index] = person;
        this.elementsCount++;
    }

    public void remove() throws OperationNotSupportedException {
        try {
			this.elements[index--] = null;
			this.elementsCount--;			
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new OperationNotSupportedException();
		}
    }

    public Person[] getElements() {
        Person[] buffer = new Person[elementsCount];
        int bufferIndex = 0;

        for (Person person : elements) {
            if (person != null) {
                buffer[bufferIndex++] = person;
            }
        }

        return buffer;
    }

    public Person findByUsername(String username) throws OperationNotSupportedException {
        List<Person> people = new ArrayList<>();

        if (username == null) {
            throw new OperationNotSupportedException();
        }

        for (Person person : elements) {

            if (person == null) {
                continue;
            }

            if (person.getUsername().equals(username)) {
                people.add(person);
            }
        }

        if (people.size() != 1) {
            throw new OperationNotSupportedException();
        }

        return people.get(0);
    }

    public Person findById(long id) throws OperationNotSupportedException {
        List<Person> people = new ArrayList<>();

        for (Person person : elements) {

            if (person == null) {
                continue;
            }

            if (person.getId() == id) {
                people.add(person);
            }
        }

        if (people.size() != 1) {
            throw new OperationNotSupportedException();
        }

        return people.get(0);
    }

    private void setElements(Person... elements) throws OperationNotSupportedException {
        if (elements.length > 16 ||
                elements.length < 1) {
            throw new OperationNotSupportedException();
        }

        this.elements = new Person[16];
        int bufferIndex = 0;

        for (Person person : elements) {
            this.elements[bufferIndex++] = person;
        }

        this.index = elements.length - 1;
    }
}
