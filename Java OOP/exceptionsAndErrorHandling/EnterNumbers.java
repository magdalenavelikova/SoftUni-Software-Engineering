package exceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnterNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = 1;
        int end = 100;
        List<Integer> numbersInRange = new ArrayList<>();

        while (numbersInRange.size() < 10) {
            try {
                start = readNumber(start, end, scanner);
                numbersInRange.add(start);
            }catch (NumberFormatException ignored){
                System.out.println("Invalid Number!");
            }catch (IllegalStateException ex){
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(numbersInRange.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }

    public static int readNumber(int start, int end, Scanner scanner) {
        int number = Integer.parseInt(scanner.nextLine());
        if (!(start < number && number < end)) {
            throw new IllegalStateException("Your number is not in range " + start + " - 100!");
        }
        return number;
    }
}
