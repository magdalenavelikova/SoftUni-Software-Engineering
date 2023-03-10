package designPattern.strategyPattern;

import java.util.Collections;
import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public Comparator<Person> reversed() {
        return Collections.reverseOrder(this);
    }
}
