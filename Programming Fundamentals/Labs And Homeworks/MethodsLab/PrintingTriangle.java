package MethodsLab;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        printTriangle(input);
    }

    public static void printTriangle(int input) {
        for (int i = 1; i <= input; i++) {
            printLine(1, i);
        }
        for (int i = input - 1; i >= 1; i--) {
            printLine(1, i);
        }
    }

    public static void printLine(int start, int end) {
        for (int j = start; j <= end; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
