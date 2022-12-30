package definingClassesExercise.opinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            Person person = new Person(data[0], Integer.parseInt(data[1]));
            people.add(person);
        }

      people.stream()
              .filter(person->person.getAge()>30)
              .sorted(Comparator.comparing(Person::getName))
              .forEach(System.out::println);
         }
}
