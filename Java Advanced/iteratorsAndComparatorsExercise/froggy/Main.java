package iteratorsAndComparatorsExercise.froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Integer[] numbers = Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        Lake lake = new Lake(numbers);

        List<String> output = new ArrayList<>();

        for (Integer number : lake) {
            output.add(String.valueOf(number));
        }

        System.out.println(String.join(", ", output));




    }
}
