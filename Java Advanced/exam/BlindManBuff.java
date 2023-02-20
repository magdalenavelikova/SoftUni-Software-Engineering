package exam;

import java.util.Arrays;
import java.util.Scanner;

public class BlindManBuff {
    private static int[] myPosition = new int[2];
    public static int row = -1;
    public static int column = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimension = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = dimension[0];
        int m = dimension[1];

        char[][] matrix = new char[n][m];
        fillMatrix(scanner, matrix);
        setMyPosition(matrix, 'B');
        String command = scanner.nextLine();
        int countOfTouchedOpponents = 0;
        int countOfMoves = 0;
        while (!command.equals("Finish")) {
            if (countOfTouchedOpponents < 3) {
                String direction = command;
                row = myPosition[0];
                column = myPosition[1];
                move(direction);
                if (isInBounds(matrix, row, column) && !isThereAObstacle(matrix, row, column)) {
                    countOfMoves++;
                    myPosition[0] = row;
                    myPosition[1] = column;
                    if (isThereOtherPlayer(matrix, row, column)) {
                        countOfTouchedOpponents++;
                        matrix[row][column] = '-';
                    }
                }
            } else {
                break;
            }
            command = scanner.nextLine();

        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d",countOfTouchedOpponents,countOfMoves);

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
            String[] data = scanner.nextLine().split("\\s+");
            for (int i = 0; i < data.length; i++) {
                matrix[row][i] = data[i].charAt(0);

            }
        }
    }

    public static void setMyPosition(char[][] matrix, char mark) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == mark) {
                    myPosition[0] = row;
                    myPosition[1] = col;
                    break;
                }

            }
        }

    }


    private static boolean isThereAObstacle(char[][] matrix, int row, int column) {
        return matrix[row][column] == 'O';
    }

    private static boolean isThereOtherPlayer(char[][] matrix, int row, int column) {
        return matrix[row][column] == 'P';
    }

    private static boolean isInBounds(char[][] matrix, int row, int column) {
        return (row >= 0 && row < matrix.length && column >= 0 && column < matrix[row].length);
    }


}
