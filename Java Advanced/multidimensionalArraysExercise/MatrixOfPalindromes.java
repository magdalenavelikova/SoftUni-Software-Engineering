package multidimensionalArraysExercise;

import java.util.Scanner;

public class MatrixOfPalindromes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int row = Integer.parseInt(input.split(" ")[0]);
        int column = Integer.parseInt(input.split(" ")[1]);
        String[][] matrix = new String[row][column];
        StringBuilder string = new StringBuilder();
        int asciiCode = 97;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                string.append((char) (asciiCode + r));
                string.append((char) (asciiCode + r + c));
                string.append((char) (asciiCode + r));
                matrix[r][c] = string.toString();
                string = new StringBuilder();
            }

        }
        print(matrix);

    }

    private static void print(String[][] matrix) {
        for (String[] x : matrix) {
            for (String y : x) {
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }

}
