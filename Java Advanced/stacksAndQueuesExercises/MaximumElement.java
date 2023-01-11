package stacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < countOfCommands; i++) {
            String input = scanner.nextLine();
            String command = input.split("\\s+")[0];

            switch (command) {
                case "1":
                    stack.push(Integer.parseInt(input.split("\\s+")[1]));
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(stack));
                    break;
            }


        }
    }
}
