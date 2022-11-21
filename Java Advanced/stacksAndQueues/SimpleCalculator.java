package stacksAndQueues;

import java.util.*;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        Deque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, tokens);
        while (stack.size() > 1) {
            int firstNumber = Integer.valueOf(stack.pop());
            String operator = stack.pop();
            int secondNumber = Integer.valueOf(stack.pop());
            if (operator.equals("+")) {
                stack.push(String.valueOf(firstNumber + secondNumber));
            } else {
                stack.push(String.valueOf(firstNumber - secondNumber));
            }

        }
        System.out.println(stack.pop());


    }
}
