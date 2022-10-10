package MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        int[] currentState = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sumOfPeople = 0;

        for (int i = 0; i < currentState.length; i++) {
            sumOfPeople += currentState[i];
        }
        if ((currentState.length * 4) - sumOfPeople > people) {
            people = liftManipulator(currentState, people);
            System.out.printf("The lift has empty spots!%n");
            printCurrentState(currentState);
        } else if ((currentState.length * 4) - sumOfPeople == people) {
            people = liftManipulator(currentState, people);
            printCurrentState(currentState);
        } else {
            people = liftManipulator(currentState, people);
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
            printCurrentState(currentState);

        }

    }


    public static int liftManipulator(int[] array, int people) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 4) {
                int freeSpots = 4 - array[i];
                if (freeSpots <= people && people > 0) {
                    array[i] += freeSpots;
                } else if (freeSpots > people && people > 0) {
                    array[i] += people;
                }
                people -= freeSpots;
            }

        }
        return people;
    }

    public static void printCurrentState(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }

    }

}
