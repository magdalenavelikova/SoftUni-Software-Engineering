package nestedLoopsLabAndExcercise;

import java.util.Scanner;

public class SumPrimeNonPrime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        boolean isNegtive = false;
        int sumPrime = 0;
        int sumNonPrime = 0;
        while (!command.equals("stop")) {
            int number = Integer.parseInt(command);
            int count = 0;
            if (number < 0) {
           //     isNegtive = true;
                System.out.println("Number is negative.");

            } else {
                for (int j = 1; j <= number; j++) {

                    if (number % j == 0) {
                        count++;
                    }

                }
                if (count == 2) {
                    sumPrime += number;
                } else {
                    sumNonPrime += number;
                }
            }
            command = scanner.nextLine();


        }
    //    if (isNegtive) {
   //         System.out.println("Number is negative.");
   //     }
        System.out.printf("Sum of all prime numbers is: %d%n", sumPrime);
        System.out.printf("Sum of all non prime numbers is: %d%n", sumNonPrime);

    }
}