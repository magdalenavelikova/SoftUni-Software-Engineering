package multidimensionalArraysExercise;

import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static boolean isPlayerWin = false;
    public static boolean isPlayerDead = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        char[][] matrix = new char[r][c];
        int[] playersIndexes = new int[2];

        for (int row = 0; row < r; row++) {
            String data = scanner.nextLine();
            for (int i = 0; i < data.length(); i++) {
                matrix[row][i] = data.charAt(i);
                if (data.charAt(i) == 'P') {
                    playersIndexes[0] = row;
                    playersIndexes[1] = i;
                }
            }
        }

        String direction = scanner.nextLine();

        for (int i = 0; i < direction.length(); i++) {
            int row = playersIndexes[0];
            int column = playersIndexes[1];
            matrix[row][column] = '.';
            switch (direction.charAt(i)) {
                case 'R':
                    column++;
                    break;
                case 'L':
                    column--;
                    break;
                case 'U':
                    row--;
                    break;
                case 'D':
                    row++;
                    break;
            }
            if (isInBounds(matrix, row, column)) {
                if (isSpotFree(matrix, row, column)) {
                    matrix[row][column] = 'P';
                } else {
                    isPlayerDead = true;
                }
                playersIndexes[0] = row;
                playersIndexes[1] = column;
            } else {
                isPlayerWin = true;
            }


            bunniesSpread(matrix);
            normalizeMatrix(matrix);

            if (isPlayerDead) {
                print(matrix);
                System.out.printf("dead: %d %d", playersIndexes[0], playersIndexes[1]);
                return;
            } else if (isPlayerWin) {
                print(matrix);
                System.out.printf("won: %d %d", playersIndexes[0], playersIndexes[1]);
                return;
            }

        }

    }

    private static void normalizeMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'b') {
                    matrix[row][col] = 'B';
                }
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

    private static boolean bunniesSpread(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    if (isInBounds(matrix, row, col - 1)) {
                        if (matrix[row][col - 1] == 'P') {
                            isPlayerDead = true;
                        }
                        if (matrix[row][col - 1] != 'B') {
                            matrix[row][col - 1] = 'b';
                        }
                    }
                    if (isInBounds(matrix, row, col + 1)) {
                        if (matrix[row][col + 1] == 'P') {
                            isPlayerDead = true;
                        }
                        if (matrix[row][col + 1] != 'B') {
                            matrix[row][col + 1] = 'b';
                        }
                    }
                    if (isInBounds(matrix, row + 1, col)) {

                        if (matrix[row + 1][col] == 'P') {
                            isPlayerDead = true;
                        }
                        if (matrix[row + 1][col] != 'B') {
                            matrix[row + 1][col] = 'b';
                        }
                    }

                    if (isInBounds(matrix, row - 1, col)) {

                        if (matrix[row - 1][col] == 'P') {
                            isPlayerDead = true;
                        }
                        if (matrix[row - 1][col] != 'B') {
                            matrix[row - 1][col] = 'b';
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean isInBounds(char[][] matrix, int row, int column) {
        return (row >= 0 && row < matrix.length && column >= 0 && column < matrix[row].length);
    }

    private static boolean isSpotFree(char[][] matrix, int row, int column) {
        return matrix[row][column] == '.';
    }
}
