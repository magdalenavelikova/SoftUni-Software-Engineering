package multidimensionalArraysExercise;

import java.util.Scanner;

public class ParkingSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(input[0]);
        int column = Integer.parseInt(input[1]);

        boolean[][] matrix = new boolean[row][column];
        String token = scanner.nextLine();

        while (!token.equalsIgnoreCase("stop")) {
            int rowStartIndex = Integer.parseInt(token.split("\\s+")[0]);
            int rowIndexForPark = Integer.parseInt(token.split("\\s+")[1]);
            int colIndexForPark = Integer.parseInt(token.split("\\s+")[2]);

            int distance = Math.abs(rowIndexForPark - rowStartIndex);
            int leftDistance = -1;
            int leftIndex = -1;
            int rightDistance = -1;
            int rightIndex = -1;
            boolean isSpotFree = false;

            if (!isSpotTaken(matrix, rowIndexForPark, colIndexForPark)) {
                distance += colIndexForPark + 1;
                matrix[rowIndexForPark][colIndexForPark] = true;
                isSpotFree = true;
            } else {

                for (int c = colIndexForPark - 1; c > 0; c--) {
                    if (!isSpotTaken(matrix, rowIndexForPark, c)) {
                        leftDistance = Math.abs(colIndexForPark - c);
                        leftIndex = c;
                        break;
                    }
                }

                for (int c = colIndexForPark + 1; c < matrix[rowIndexForPark].length; c++) {
                    if (!isSpotTaken(matrix, rowIndexForPark, c)) {
                        rightDistance = Math.abs(colIndexForPark - c);
                        rightIndex = c;
                        break;
                    }
                }

                if ((rightDistance < leftDistance && rightDistance != -1) || (leftDistance == -1 && rightIndex != -1)) {
                    matrix[rowIndexForPark][rightIndex] = true;
                    distance += rightIndex + 1;
                    isSpotFree = true;
                } else if ((leftDistance <= rightDistance && leftDistance != -1) || (rightDistance == -1 && leftIndex != -1)) {
                    matrix[rowIndexForPark][leftIndex] = true;
                    distance += leftIndex + 1;
                    isSpotFree = true;
                }

            }

            if (!isSpotFree) {
                System.out.println("Row " + rowIndexForPark + " full");
            } else {
                System.out.println(distance);
            }
            token = scanner.nextLine();
        }
    }

    private static boolean isSpotTaken(boolean[][] matrix, int row, int col) {
        if (isInBounds(matrix, row, col)) {
            return (matrix[row][col]);
        }
        return true;
    }

    private static boolean isInBounds(boolean[][] matrix, int row, int col) {

        return (row >= 0 && row < matrix.length && col > 0 && col < matrix[row].length);
    }
}
