package multidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int row = Integer.parseInt(input.split("\\s+")[0]);
        int column = Integer.parseInt(input.split("\\s+")[1]);
        int[][] matrix = new int[row][column];
        for (int r = 0; r < row; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int[] indexArr = new int[2];
        int maxSum = Integer.MIN_VALUE;
        for (int r = 0; r < row - 2; r++) {
            for (int c = 0; c < column - 2; c++) {
                int sum = 0;
                for (int rowIndex = r; rowIndex < r + 3; rowIndex++) {
                    for (int colIndex = c; colIndex < c + 3; colIndex++) {
                        sum += matrix[rowIndex][colIndex];
                    }
                }


                if (sum > maxSum) {
                    maxSum = sum;
                    indexArr[0] = r;
                    indexArr[1] = c;

                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int r = indexArr[0]; r < indexArr[0] + 3; r++) {
            for (int c = indexArr[1]; c < indexArr[1] + 3; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }

    }
}
