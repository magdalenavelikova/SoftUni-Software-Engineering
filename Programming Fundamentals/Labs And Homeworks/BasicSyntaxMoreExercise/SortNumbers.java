package BasicSyntaxMoreExercise;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        int maxNumber = Integer.max(thirdNumber, Integer.max(firstNumber, secondNumber));
        int minNumber = Integer.min(thirdNumber, Integer.min(firstNumber, secondNumber));
        int sum = firstNumber + secondNumber + thirdNumber;
        int middleNumber = sum - (maxNumber + minNumber);
        System.out.println(maxNumber);
        System.out.println(middleNumber);
        System.out.println(minNumber);
    }
}
