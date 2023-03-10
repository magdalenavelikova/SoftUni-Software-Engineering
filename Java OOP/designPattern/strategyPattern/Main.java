package designPattern.strategyPattern;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people=new ArrayList<>();
        people.add(new Person("Pesho","656565"));
        people.add(new Person("DSF","656565"));
        people.add(new Person("dfs","656565"));
        people.add(new Person("Pesdffsho","656565"));
        people.add(new Person("Pesdfsho","656565"));

        PersonNameComparator personNameComparator=new PersonNameComparator();
        people.sort(personNameComparator);
        people.sort(personNameComparator.reversed());
    }

}
