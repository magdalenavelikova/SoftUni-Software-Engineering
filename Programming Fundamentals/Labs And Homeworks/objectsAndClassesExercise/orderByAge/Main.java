package objectsAndClassesExercise.orderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        List<Person> personsList = new ArrayList<>();
        while (!inputLine.equals("End")) {
            Person currentPerson = new Person(
                    inputLine.split(" ")[0],
                    inputLine.split(" ")[1],
                    Integer.parseInt(inputLine.split(" ")[2]));


            personsList.add(currentPerson);
            inputLine = scanner.nextLine();
        }
        personsList.sort(Comparator.comparing(Person::getAge));
        for (Person person : personsList) {
            System.out.printf("%s with ID: %s is %d years old.%n", person.getName(), person.getId(), person.getAge());
        }

    }
}
