package examPreparation;

import java.util.Scanner;

public class ReVolt {
    public static int[] playerIndexes = new int[2];
    public static int row = -1;
    public static int column = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimension = Integer.parseInt(scanner.nextLine());
        int countOfCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[dimension][dimension];
        fillMatrix(scanner, matrix);

        for (int i = 0; i < countOfCommands; i++) {

            String direction = scanner.nextLine();
            row = playerIndexes[0];
            column = playerIndexes[1];
            matrix[row][column] = '-';
            movePlayer(dimension, matrix, direction);
            if (isThereABonus(matrix, row, column)) {
                movePlayer(dimension, matrix, direction);
            }
            if (isThereATrap(matrix, row, column)) {
                row = playerIndexes[0];
                column = playerIndexes[1];
            }
            if (matrix[row][column] == 'F') {
                matrix[row][column] = 'f';
                System.out.println("Player won!");
                print(matrix);
                return;
            }
            matrix[row][column] = 'f';
            playerIndexes[0] = row;
            playerIndexes[1] = column;

        }
        System.out.println("Player lost!");
        print(matrix);

    }

    private static void movePlayer(int dimension, char[][] matrix, String direction) {
        switch (direction) {
            case "right":
                column++;
                if (column >= dimension) {
                    column = 0;
                }
                break;
            case "left":
                column--;
                if (column < 0) {
                    column = matrix.length - 1;
                }
                break;
            case "up":
                row--;
                if (row < 0) {
                    row = dimension - 1;
                }
                break;
            case "down":
                row++;
                if (row >= dimension) {
                    row = 0;
                }
                break;
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

    private static boolean isThereABonus(char[][] matrix, int row, int column) {
        return matrix[row][column] == 'B';
    }

    private static boolean isThereATrap(char[][] matrix, int row, int column) {
        return matrix[row][column] == 'T';
    }

    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String data = scanner.nextLine();
            for (int i = 0; i < data.length(); i++) {
                matrix[row][i] = data.charAt(i);
                if (data.charAt(i) == 'f') {
                    playerIndexes[0] = row;
                    playerIndexes[1] = i;
                }
            }
        }
    }
}
