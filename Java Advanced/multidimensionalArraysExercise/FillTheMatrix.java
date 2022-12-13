package multidimensionalArraysExercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int size = Integer.parseInt(input.split(",\\s+")[0]);
        String pattern = input.split(",\\s+")[1];
        int matrix[][] = new int[size][size];

        if (pattern.equals("A")) {
            patternA(size, matrix);
        }
        if (pattern.equals("B")) {
            patternB(size, matrix);
        }
        print(matrix);
    }

    private static void print(int[][] matrix) {
        for (int[] x : matrix) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();

        }
    }

    private static void patternB(int size, int[][] matrix) {
        int start = 1;
        for (int c = 0; c < size; c++) {
            if (c % 2 == 0) {
                for (int r = 0; r < size; r++) {
                    matrix[r][c] = start;
                    start++;
                }
            } else {
                for (int r = size - 1; r >= 0; r--) {
                    matrix[r][c] = start;
                    start++;
                }

            }
        }
    }

    private static void patternA(int size, int[][] matrix) {
        int start = 1;
        for (int c = 0; c < size; c++) {
            for (int r = 0; r < size; r++) {
                matrix[r][c] = start;
                start++;
            }
        }
    }
}
