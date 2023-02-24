package workingWithAbstraction;

import java.util.Scanner;

public class RhombusOfStars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printRhombus(n);
    }

    public static void printRhombus(int size) {
        for (int i = 1; i <= size; i++) {
            printTriangle(size - i, i);
        }
        for (int i = 1; i < size; i++) {
            printTriangle(i, size - i);
        }
    }

    private static void printTriangle(int counterForSpaces, int counterForStars) {
        for (int i = 0; i < counterForSpaces; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < counterForStars; i++) {
            System.out.print("* ");
        }

        System.out.println();
    }
}
