package iteratorsAndComparatorsExercise.stackWithIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Stack<Integer> stack = new Stack<>();
        while (!input.equals("END")) {
            input = input.replace(",", "");
            String[] commandLine = input.split("\\s+");
            String command = commandLine[0];
            switch (command) {
                case "Push":
                    for (int i = 1; i < commandLine.length; i++) {
                        stack.push(Integer.parseInt(commandLine[i]));
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (IllegalArgumentException e) {
                        System.out.println("No elements");
                    }

                    break;
            }

            input = scanner.nextLine();
        }

        stack.forEach(System.out::println);
        stack.forEach(System.out::println);

    }
}
