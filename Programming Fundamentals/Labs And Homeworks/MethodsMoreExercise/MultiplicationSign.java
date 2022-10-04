package MethodsMoreExercise;

import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        if (n1 == 0 || n2 == 0 || n3 == 0) {
            System.out.println("zero");
        } else {
            if (isPositive(n1, n2, n3)) {
                System.out.println("positive");
            } else {
                System.out.println("negative");
            }
        }

    }

    private static boolean isPositive(int n1, int n2, int n3) {
        int counter = 0;
        if (n1 < 0) {
            counter++;
        }
        if (n2 < 0) {
            counter++;
        }
        if (n3 < 0) {
            counter++;
        }
        if (counter == 0 || counter == 2) {
            return true;
        } else {
            return false;
        }
    }
}
