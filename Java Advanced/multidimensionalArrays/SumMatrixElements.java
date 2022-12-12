package multidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sizes = scanner.nextLine();
        int[][] matrix=readMatrix(scanner, sizes);
       int sum=0;
        for (int[] rows : matrix) {
            for (int column : rows) {
                sum+=column;
            }

        }
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);
    }

    private static int[][] readMatrix(Scanner scanner, String sizes) {
        int row = Integer.parseInt(sizes.split(", ")[0]);
        int column = Integer.parseInt(sizes.split(", ")[1]);
        int[][] matrix = new int[row][column];

        for (int r = 0; r < row; r++) {
            matrix[r]= Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }


}
