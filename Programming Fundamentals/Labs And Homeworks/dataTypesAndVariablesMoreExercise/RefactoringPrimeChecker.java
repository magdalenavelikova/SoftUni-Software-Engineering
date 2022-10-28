package dataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class RefactoringPrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 2; i <= number; i++) {
            int count = 0;
            boolean isPrime = true;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count > 2) {
                isPrime = false;
            }
            System.out.printf("%d -> %b%n", i, isPrime);

        }

    }

}
