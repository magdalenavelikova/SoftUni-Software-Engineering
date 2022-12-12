package multidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[row][];

        for (int r = 0; r < row; r++) {
            matrix[r] = readArray(scanner);
        }


        List<int[]> valueForReplacement = new ArrayList<>();
        int[] indexForInvalidNumber = readArray(scanner);

        int invalidNumber = matrix[indexForInvalidNumber[0]][indexForInvalidNumber[1]];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == invalidNumber) {
                    int correctValue = getSum(matrix, r, c, invalidNumber);
                    valueForReplacement.add(new int[]{r, c, correctValue});
                }
            }
        }
        for (int[] entry : valueForReplacement) {
            matrix[entry[0]][entry[1]] = entry[2];
        }


        for (int[] x : matrix) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    private static int getSum(int[][] matrix, int row, int column, int invalidNumber) {
        int sum = 0;

        if (isValidIndex(row - 1, matrix.length)) {
            if (matrix[row - 1][column] != invalidNumber) {
                sum += matrix[row - 1][column];
            }
        }
        if (isValidIndex(row + 1, matrix.length)) {
            if (matrix[row + 1][column] != invalidNumber) {
                sum += matrix[row + 1][column];
            }
        }
        if (isValidIndex(column - 1, matrix[row].length)) {
            if (matrix[row][column - 1] != invalidNumber) {
                sum += matrix[row][column - 1];
            }
        }
        if (isValidIndex(column + 1, matrix[row].length)) {
            if (matrix[row][column + 1] != invalidNumber) {
                sum += matrix[row][column + 1];
            }
        }
        return sum;

    }

    private static boolean isValidIndex(int index, int length) {
        return (index >= 0 && index < length);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
