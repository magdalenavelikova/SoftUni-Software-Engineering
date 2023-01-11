package stacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InfixToPostfix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String token : input) {

            if (isOperator(token)) {

                if (token.equals("(") || token.equals(")")) {

                    if (token.equals("(")) {
                        stack.push(token);
                    } else {

                        while (!stack.peek().equals("(")) {
                            queue.offer(stack.pop());
                        }
                        stack.pop();
                    }
                } else {

                    if (stack.isEmpty()) {
                        stack.push(token);
                    } else {
                        String operator = stack.peek();

                        if (getPriority(token) <= getPriority(operator)) {
                            queue.offer(stack.pop());
                            stack.push(token);
                        } else {
                            stack.push(token);
                        }
                    }
                }
            } else {
                queue.offer(token);
            }

        }

        for (String s : stack) {
            queue.offer(s);
        }

        System.out.println(String.join(" ", queue));
    }

    private static int getPriority(String operator) {

        if (operator.equals("*") || operator.equals("/")) {
            return 2;
        } else if (operator.equals("-") || operator.equals("+")) {
            return 1;
        }
        return 0;
    }

    private static boolean isOperator(String token) {
        String regex = "[+\\-*\\/()]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(token);
        if (matcher.find()) {
            return true;
        }
        return false;
    }
}
