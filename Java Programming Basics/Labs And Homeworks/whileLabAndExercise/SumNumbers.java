package whileLabAndExercise;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        while (sum<firstNumber) {
            sum += Integer.parseInt(scanner.nextLine());
        }

        System.out.println(sum);
    }
}
