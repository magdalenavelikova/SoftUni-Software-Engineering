package exceptionsAndErrorHandling;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] range = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        System.out.printf("Range: [%d...%d]%n", range[0], range[1]);
        boolean isValid = false;

        while (!isValid) {

            Optional<Integer> number;
            String input = scanner.nextLine();
            String output = "Invalid number: " + input;

            try {
                number = Optional.of(Integer.parseInt(input));
            } catch (NumberFormatException ignored) {
                number = Optional.empty();
            }

            if (number.isPresent() && isInRange(range, number.get())) {
                output = "Valid number: " + number.get();
                isValid = true;

            }
            System.out.println(output);
        }


    }

    private static boolean isInRange(int[] range, int number) {
        return number >= range[0] && number <= range[1];
    }
}
