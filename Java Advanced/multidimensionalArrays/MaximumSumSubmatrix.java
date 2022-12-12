package multidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumSubmatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dimension = scanner.nextLine();
        int rows = Integer.parseInt(dimension.split(", ")[0]);
        int columns = Integer.parseInt(dimension.split(", ")[1]);
        int[][] matrix = new int[rows][columns];
        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int indexForRow = -1;
        int indexForColumn = -1;
        int maxSum = Integer.MIN_VALUE;
        for (int r = 0; r < rows - 1; r++) {
            for (int c = 0; c < columns - 1; c++) {
                int sum = matrix[r][c] + matrix[r][c + 1]
                        + matrix[r + 1][c] + matrix[r + 1][c + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                    indexForRow = r;
                    indexForColumn = c;

                }
            }
        }
        System.out.print(matrix[indexForRow][indexForColumn] + " " + matrix[indexForRow][indexForColumn + 1]);
        System.out.println();
        System.out.print(matrix[indexForRow + 1][indexForColumn] + " " + matrix[indexForRow + 1][indexForColumn + 1]);
        System.out.println();
        System.out.println(maxSum);
    }
}
