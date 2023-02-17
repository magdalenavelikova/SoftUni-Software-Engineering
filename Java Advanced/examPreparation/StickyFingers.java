package examPreparation;

import java.util.Scanner;

public class StickyFingers {
    private static int[] dillingerPosition = new int[2];
    public static int row = -1;
    public static int column = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        String[] direction = scanner.nextLine().split(",");
        fillMatrix(scanner, matrix);
        setDillingerPosition(matrix, 'D');
        int stolenValue = 0;
        boolean isGameOver = false;
        for (int i = 0; i < direction.length; i++) {
            row = dillingerPosition[0];
            column = dillingerPosition[1];

            move(direction[i]);
            if (isInBounds(matrix, row, column)) {
                matrix[dillingerPosition[0]][dillingerPosition[1]] = '+';
                if (isSpotFree(matrix, row, column)) {
                    matrix[row][column] = 'D';

                    dillingerPosition[0] = row;
                    dillingerPosition[1] = column;
                }
                if (isThereAHouse(matrix, row, column)) {
                    matrix[row][column] = 'D';
                    int currentStolenValues = row * column;
                    stolenValue += currentStolenValues;
                    dillingerPosition[0] = row;
                    dillingerPosition[1] = column;
                    System.out.printf("You successfully stole %d$.%n", currentStolenValues);
                }
                if (isThereAPolice(matrix, row, column)) {

                    dillingerPosition[0] = row;
                    dillingerPosition[1] = column;
                    matrix[row][column] = '#';
                    System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenValue);
                    print(matrix);
                    return;
                }
            } else {
                System.out.println("You cannot leave the town, there is police outside!");

            }

        }

        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenValue);

        print(matrix);

    }

    private static void print(char[][] matrix) {
        for (char[] x : matrix) {
            for (char y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int i = 0; i < data.length; i++) {
                matrix[row][i] = data[i].charAt(0);

            }
        }
    }

    private static boolean isThereAHouse(char[][] matrix, int row, int column) {
        return matrix[row][column] == '$';
    }

    private static boolean isThereAPolice(char[][] matrix, int row, int column) {
        return matrix[row][column] == 'P';
    }

    private static boolean isSpotFree(char[][] matrix, int row, int column) {
        return matrix[row][column] == '+';
    }

    private static void move(String direction) {
        switch (direction) {
            case "right":
                column++;
                break;
            case "left":
                column--;
                break;
            case "up":
                row--;
                break;
            case "down":
                row++;
                break;
        }
    }

    public static void setDillingerPosition(char[][] matrix, char mark) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == mark) {
                    dillingerPosition[0] = row;
                    dillingerPosition[1] = col;
                    break;
                }

            }
        }
    }

    private static boolean isInBounds(char[][] matrix, int row, int column) {
        return (row >= 0 && row < matrix.length && column >= 0 && column < matrix[row].length);
    }

}
