package examPreparation;

import java.util.Scanner;

public class NavyBattle {
    public static int[] submarineIndexes = new int[2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        fillMatrix(scanner, matrix);
        int battleCruiserCounter = 0;
        int mineCounter = 0;

        while (battleCruiserCounter <= 3 && mineCounter <= 3) {
            String direction = scanner.nextLine();
            int row = submarineIndexes[0];
            int column = submarineIndexes[1];
            matrix[row][column] = '-';
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
            if (isInBounds(matrix, row, column)) {
                submarineIndexes[0] = row;
                submarineIndexes[1] = column;

                if (isThereBattleCruiser(matrix, row, column)) {
                    matrix[row][column] = 'S';
                    battleCruiserCounter++;
                    if (battleCruiserCounter == 3) {

                        System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                        print(matrix);
                        return;
                    }
                } else if (isThereMine(matrix, row, column)) {
                    matrix[row][column] = 'S';
                    mineCounter++;
                    if (mineCounter == 3) {
                        System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", row, column);
                        print(matrix);
                        return;
                    }
                }
                matrix[row][column] = 'S';
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


    private static boolean isThereBattleCruiser(char[][] matrix, int row, int column) {
        return matrix[row][column] == 'C';
    }

    private static boolean isThereMine(char[][] matrix, int row, int column) {
        return matrix[row][column] == '*';
    }

    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String data = scanner.nextLine();
            for (int i = 0; i < data.length(); i++) {
                matrix[row][i] = data.charAt(i);
                if (data.charAt(i) == 'S') {
                    submarineIndexes[0] = row;
                    submarineIndexes[1] = i;
                }
            }
        }
    }
}
