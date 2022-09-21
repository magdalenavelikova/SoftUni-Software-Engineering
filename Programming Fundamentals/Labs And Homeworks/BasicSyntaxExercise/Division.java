package BasicSyntaxExercise;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        if (number % 10 == 0) {
            System.out.println("The number is divisible by 10");
        } else if (number % 7 == 0) {
            System.out.println("The number is divisible by 7");
        } else if (number % 6 == 0) {
            System.out.println("The number is divisible by 6");
        } else if (number % 3 == 0)  {
            System.out.println("The number is divisible by 3");
        } else if (number % 2 == 0) {
            System.out.println("The number is divisible by 2");
        } else{
            System.out.println("Not divisible");
        }
    }
}
