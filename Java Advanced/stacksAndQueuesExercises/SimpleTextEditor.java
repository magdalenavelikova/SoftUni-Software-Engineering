package stacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        1 {string}" - appends [string] to the end of the text.
//•	"2 {count}" - erases the last [count] elements from the text.
//•	"3 {index}" - returns the element at position [index] from the text.
//•	"4" - undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation.
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
