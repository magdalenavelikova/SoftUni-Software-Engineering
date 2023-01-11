package stacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String command = input.split("\\s+")[0];

            switch (command) {
                case "1":
                    String argument = input.split("\\s+")[1];
                    stack.push(text.toString());
                    text.append(argument);
                    break;
                case "2":
                    int count = Integer.parseInt(input.split("\\s+")[1]);
                    stack.push(text.toString());
                    text = new StringBuilder(text.delete(text.length() - count, text.length()));
                    break;
                case "3":
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    text = new StringBuilder(stack.pop());
                    break;
            }


        }

    }
}
