package functionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int last = Integer.parseInt(scanner.nextLine());

        List<Integer> dividerList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> predicate = number -> {
            for (Integer divider : dividerList) {
                if (number % divider != 0) {
                    return false;
                }
            }
            return true;
        };

        IntStream.rangeClosed(1, last).forEach(n -> {
            if (predicate.test(n)) {
                System.out.print(n + " ");
            }
        });


    }
}
