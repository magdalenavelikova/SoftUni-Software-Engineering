package whileLabAndExercise;

import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int minNumber = Integer.MAX_VALUE;
        while (!input.equals("Stop")) {
            int number = Integer.parseInt(input);
            if (number < minNumber) {
                minNumber = number;
            }
            input= scanner.nextLine();
        }
        System.out.println(minNumber);
    }
}
