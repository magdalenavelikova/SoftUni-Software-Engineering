package ListsMoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        String message = "";
        for (int i = 0; i < integerList.size(); i++) {
            int currentNumber = integerList.get(i);
            int sum = 0;
            while (currentNumber > 0) {
                sum += currentNumber % 10;
                currentNumber = currentNumber / 10;
            }
            int index = sum;

            while (index > input.length() - 1) {
                index = index - (input.length());
            }
            message += input.charAt(index);
            input = input.replaceFirst(String.valueOf(input.charAt(index)), "");

        }
        System.out.println(message);
    }
}

