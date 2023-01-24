package iteratorsAndComparatorsExercise.comparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> personList = new ArrayList<>();
        while (!input.equals("END")) {
            String[] personInfo = input.split("\\s+");
            Person person = new Person(personInfo[0], Integer.parseInt(personInfo[1]), personInfo[2]);
            personList.add(person);
            input = scanner.nextLine();
        }
        int indexVIP = Integer.parseInt(scanner.nextLine());
        int counterForSame = 0;
        int counterForDifferent = 0;
        Person personToCompare = personList.get(indexVIP - 1);

        for (Person person : personList) {
            if (person.compareTo(personToCompare) == 0) {
                counterForSame++;
            }else {
                counterForDifferent++;
            }
        }
        if (counterForSame == 1) {
            System.out.println("No matches");
        }else {
            System.out.print(counterForSame+" "+counterForDifferent+" "+ personList.size());
        }
        }

    }

