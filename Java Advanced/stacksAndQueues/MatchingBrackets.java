package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> stackOfIndexesForOpenBrackets = new ArrayDeque<>();
        PriorityQueue<Integer> numbers = new PriorityQueue<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stackOfIndexesForOpenBrackets.push(i);
            } else if (input.charAt(i) == ')') {
                String matchingString = input.substring(stackOfIndexesForOpenBrackets.pop(), i + 1);
                System.out.println(matchingString);
            }
        }

    }
}
