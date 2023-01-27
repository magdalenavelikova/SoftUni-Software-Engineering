package multidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] dimension = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        char[][] matrix = new char[dimension[0]][dimension[1]];

        fillMatrix(scanner, matrix);

        char newSymbol = scanner.nextLine().charAt(0);
        int[] indexes = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = indexes[0];
        int col = indexes[1];
        char oldSymbol = matrix[row][col];

        paint(matrix, newSymbol, oldSymbol, row, col);

        print(matrix);


    }

    private static void paint(char[][] matrix, char newSymbol, char oldSymbol, int row, int col) {

        if (!isInBounds(matrix, row, col) || (matrix[row][col] != oldSymbol)) {
            return;
        }

        matrix[row][col] = newSymbol;

        paint(matrix, newSymbol, oldSymbol, row + 1, col);
        paint(matrix, newSymbol, oldSymbol, row - 1, col);
        paint(matrix, newSymbol, oldSymbol, row, col + 1);
        paint(matrix, newSymbol, oldSymbol, row, col - 1);

    }

    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int i = 0; i < data.length; i++) {
                matrix[row][i] = data[i].charAt(0);

            }
        }
    }

    private static void print(char[][] matrix) {
        for (char[] x : matrix) {
            for (char y : x) {
                System.out.print(y);
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(char[][] matrix, int row, int column) {
        return (row >= 0 && row < matrix.length && column >= 0 && column < matrix[row].length);
    }
}
