package multidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        fillMatrix(scanner, size, matrix);

        int firstSum = getSumPrimaryDiagonal(size, matrix);
        int secondSum = getSumSecondaryDiagonal(size, matrix);

        System.out.println(Math.abs(firstSum - secondSum));
    }

    private static int getSumSecondaryDiagonal(int size, int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < size; row++) {
            sum += matrix[row][size - row - 1];
        }
        return sum;
    }

    private static int getSumPrimaryDiagonal(int size, int[][] matrix) {
        int sum = 0;
        for (int index = 0; index < size; index++) {
            sum += matrix[index][index];

        }
        return sum;
    }

    private static void fillMatrix(Scanner scanner, int size, int[][] matrix) {
        for (int r = 0; r < size; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
