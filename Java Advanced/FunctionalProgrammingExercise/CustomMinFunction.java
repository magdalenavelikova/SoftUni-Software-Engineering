package functionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

     Function<int[], Integer> getMinNumber = arr -> {
            int min = Integer.MAX_VALUE;
            for (int j : arr) {
                if (j < min) {
                    min = j;
                }
            }
            return min;

        };
      //  Function<int[], Integer> getMinNumber = arr -> Arrays.stream(arr).min().orElseThrow(()->new RuntimeException());
        System.out.println(getMinNumber.apply(numbers));
    }
}
