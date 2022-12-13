package multidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dimensions = scanner.nextLine();
        int row = Integer.parseInt(dimensions.split("\\s+")[0]);
        int column = Integer.parseInt(dimensions.split("\\s+")[1]);
        String[][] matrix = new String[row][column];

        for (int r = 0; r < row; r++) {
            matrix[r] = (scanner.nextLine().split("\\s+"));
        }
        String[] input = scanner.nextLine().split("\\s+");
        while (!input[0].equals("END")) {
            boolean isValidCommand = true;
            if (input.length == 5) {
                String command = input[0];
                int row1 = Integer.parseInt(input[1]);
                int col1 = Integer.parseInt(input[2]);
                int row2 = Integer.parseInt(input[3]);
                int col2 = Integer.parseInt(input[4]);
                if (isValidIndexByRow(row1, row) && isValidIndexByRow(row2, row)
                        && isValidIndexByColumn(col1, column) && isValidIndexByColumn(col2, column)
                && command.equals("swap")) {
                    String firstString = matrix[row1][col1];
                    String secondString = matrix[row2][col2];
                    matrix[row1][col1] = secondString;
                    matrix[row2][col2] = firstString;
                    print(matrix);

                } else {
                    isValidCommand = false;

                }
            } else {
                isValidCommand = false;

            }


            if (!isValidCommand) {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine().split("\\s+");
        }
        System.out.println();
    }

    private static boolean isValidIndexByRow(int index, int row) {
        return (index >= 0 && index < row);
    }

    private static boolean isValidIndexByColumn(int index, int column) {
        return (index >= 0 && index < column);
    }

    private static void print(String[][] matrix) {
        for (String[] x : matrix) {
            for (String y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
