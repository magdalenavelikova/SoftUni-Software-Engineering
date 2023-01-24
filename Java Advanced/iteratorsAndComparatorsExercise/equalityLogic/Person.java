package iteratorsAndComparatorsExercise.equalityLogic;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private  String name;
    private  int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Person person = (Person) otherObject;
        return  age == person.age
                && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
                return Objects.hash(name, age);
//        int hash = 7;
//        hash = 31 * hash + age;
//        hash = 31 * hash + (name == null ? 0 : name.hashCode());
//        return hash;
    }

    @Override
    public String toString() {
        return String.format("%s %d",name,age);
    }

    @Override
    public int compareTo(Person other) {
        return Comparator.comparing(Person::getName).thenComparing(Person::getAge).compare(this, other);
    }
}
