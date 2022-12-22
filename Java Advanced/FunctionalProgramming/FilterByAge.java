package FunctionalProgramming;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge {

    public static class Person {
        String name;
        int age;

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
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Function<Scanner, Person> readPerson = sc -> {
            String[] input = sc.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            return new Person(name, age);
        };

        List<Person> people = IntStream.range(0, n)
                .mapToObj(p -> readPerson.apply(scanner))
                .collect(Collectors.toList());

        String condition = scanner.nextLine();

        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Consumer<Person> printPerson = getPrint(format);

        Predicate<Person> isConditionTrue = getFilterByAge(condition, age);


        people.stream()
                .filter(p -> isConditionTrue.test(p))
                .forEach(p -> printPerson.accept(p));
    }

    public static Consumer<Person> getPrint(String format) {

        switch (format) {
            case "name":
                return p -> System.out.println(p.getName());
            case "age":
                return p -> System.out.println(p.getAge());
            case "name age":
                return p -> System.out.println(p.getName() + " - " + p.getAge());
            default:
                throw new IllegalArgumentException("Unknown format " + format);
        }
    }

    public static Predicate<Person> getFilterByAge(String condition, int age) {

        switch (condition) {
            case "older":
                return p -> p.getAge() >= age;
            case "younger":
                return p -> p.getAge() <= age;
            default:
                throw new IllegalArgumentException("Unknown condition " + condition);
        }

    }
}

