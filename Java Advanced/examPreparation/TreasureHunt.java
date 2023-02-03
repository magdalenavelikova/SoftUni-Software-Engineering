package examPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class TreasureHunt {
    public static int[] playerIndexes = new int[2];
    public static int[] treasureIndexes = new int[2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimension = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        char[][] matrix = new char[dimension[0]][dimension[1]];

        fillMatrix(scanner, matrix);

        String input = scanner.nextLine();
        ArrayDeque<String> validCommands = new ArrayDeque<>();
        while (!input.equals("Finish")) {
            String direction = input;
            int row = playerIndexes[0];
            int column = playerIndexes[1];

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
                default:
                    throw new IllegalArgumentException("Invalid direction!");
            }
            if (isInBounds(matrix, row, column)) {
                if(!isThereTree(matrix,row,column)){
                    playerIndexes[0] = row;
                    playerIndexes[1] = column;
                   validCommands.offer(direction);
                }
            }

            input = scanner.nextLine();
        }
        if (playerIndexes[0] == treasureIndexes[0]
                && playerIndexes[1] == treasureIndexes[1]) {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            StringBuilder output = new StringBuilder();
            while (!validCommands.isEmpty()) {
                output.append(String.format("%s, ", validCommands.poll()));
            }
            String stringOutput = output.deleteCharAt(output.length() - 2).toString();
            System.out.print(stringOutput);
        } else {
            System.out.println("The map is fake!");
        }
    }


    private static boolean isInBounds(char[][] matrix, int row, int column) {
        return (row >= 0 && row < matrix.length && column >= 0 && column < matrix[row].length);
    }


    private static boolean isThereTree(char[][] matrix, int row, int column) {
        return matrix[row][column] == 'T';
    }


    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String data = scanner.nextLine();
            data = data.replaceAll("\\s", "");
            if (data.contains("Y")) {
                playerIndexes[0] = row;
                playerIndexes[1] = data.indexOf("Y");
            }
            if (data.contains("X")) {
                treasureIndexes[0] = row;
                treasureIndexes[1] = data.indexOf("X");
            }

            for (int i = 0; i < matrix[row].length; i++) {

                matrix[row][i] = data.charAt(i);


            }
        }
    }
}
