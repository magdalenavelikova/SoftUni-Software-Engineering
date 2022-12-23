package functionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> evenNumbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

        System.out.println(evenNumbers.stream()
                .sorted()
                .map((String::valueOf))
                .collect(Collectors.joining(", ")));

    }
}
