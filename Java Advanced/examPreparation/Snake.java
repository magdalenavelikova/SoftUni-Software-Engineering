package examPreparation;

import java.util.Scanner;

public class Snake {
    private static int[] snakePosition = new int[2];
    public static int row = -1;
    public static int column = -1;

    public static void main(String[] args) {
        int[] firstEntryTunnel = new int[2];
        int[] secondEntryTunnel = new int[2];

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int foodQuantity = 0;
        char[][] matrix = new char[n][n];
        fillMatrix(scanner, matrix);
        setSnakePosition(matrix, 'S');
        setBurrowPosition(firstEntryTunnel, secondEntryTunnel, matrix);
        boolean isGameOver = false;

        while (foodQuantity < 10 && !isGameOver) {

            String direction = scanner.nextLine();

            row = snakePosition[0];
            column = snakePosition[1];
            matrix[row][column] = '.';
            move(direction);
            if (isInBounds(matrix, row, column)) {

                if (isThereAFood(matrix, row, column)) {
                    foodQuantity += 1;
                    matrix[row][column] = 'S';
                }
                snakePosition[0] = row;
                snakePosition[1] = column;

                if (matrix[row][column] == 'B') {
                    matrix[firstEntryTunnel[0]][firstEntryTunnel[1]] = '.';
                    matrix[secondEntryTunnel[0]][secondEntryTunnel[1]] = '.';
                    if (row == firstEntryTunnel[0] && column == firstEntryTunnel[1]) {
                        snakePosition[0] = secondEntryTunnel[0];
                        snakePosition[1] = secondEntryTunnel[1];
                    } else if (row == secondEntryTunnel[0] && column == secondEntryTunnel[1]) {
                        snakePosition[0] = firstEntryTunnel[0];
                        snakePosition[1] = firstEntryTunnel[1];
                    }
                }

            } else {
                isGameOver = true;
                break;
            }
        }
        if (isGameOver) {
            System.out.println("Game over!");
        }
        if (foodQuantity == 10) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + foodQuantity);
        print(matrix);
    }

    private static void setBurrowPosition(int[] firstEntryTunnel, int[] secondEntryTunnel, char[][] matrix) {
        int counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] == 'B') {
                    if (counter == 0) {
                        firstEntryTunnel[0] = row;
                        firstEntryTunnel[1] = col;
                        counter++;
                    } else {
                        secondEntryTunnel[0] = row;
                        secondEntryTunnel[1] = col;
                    }
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

    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String data = scanner.nextLine();
            for (int i = 0; i < data.length(); i++) {
                matrix[row][i] = data.charAt(i);

            }
        }
    }

    public static void setSnakePosition(char[][] matrix, char mark) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == mark) {
                    snakePosition[0] = row;
                    snakePosition[1] = col;
                    break;
                }

            }
        }

    }

    private static boolean isSpotFree(char[][] matrix, int row, int column) {
        return matrix[row][column] == '-';
    }

    private static boolean isThereAFood(char[][] matrix, int row, int column) {
        return matrix[row][column] == '*';
    }

    private static boolean isInBounds(char[][] matrix, int row, int column) {
        return (row >= 0 && row < matrix.length && column >= 0 && column < matrix[row].length);
    }

}
