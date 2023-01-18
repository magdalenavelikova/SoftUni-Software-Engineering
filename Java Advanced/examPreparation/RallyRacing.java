package examPreparation;

import java.util.Scanner;


public class RallyRacing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();
        int[] firstEntryTunnel = new int[2];
        int[] secondEntryTunnel = new int[2];

        String[][] matrix = new String[dimensions][dimensions];
        int[] currentPosition = {0, 0};
        int distance = 0;

        fillTheMatrix(scanner, matrix, firstEntryTunnel, secondEntryTunnel);

        String direction = scanner.nextLine();
        boolean isFinished = false;


        while (!direction.equals("End")) {

            if (!isFinished) {

                int row = currentPosition[0];
                int column = currentPosition[1];

                switch (direction) {
                    case "left":
                        column--;
                        break;
                    case "right":
                        column++;
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


                distance += 10;
                currentPosition[0] = row;
                currentPosition[1] = column;

                if (matrix[row][column].equals("F")) {
                    isFinished = true;
                }

                if (matrix[row][column].equals("T")) {
                    matrix[row][column] = ".";
                    distance += 20;

                    if (row == firstEntryTunnel[0] && column == firstEntryTunnel[1]) {
                        matrix[secondEntryTunnel[0]][secondEntryTunnel[1]] = ".";
                        currentPosition[0] = secondEntryTunnel[0];
                        currentPosition[1] = secondEntryTunnel[1];
                    } else if (row == secondEntryTunnel[0] && column == secondEntryTunnel[1]) {
                        matrix[firstEntryTunnel[0]][firstEntryTunnel[1]] = ".";
                        currentPosition[0] = firstEntryTunnel[0];
                        currentPosition[1] = firstEntryTunnel[1];
                    }
                }
            }
            direction = scanner.nextLine();
        }

        matrix[currentPosition[0]][currentPosition[1]] = "C";
        if (isFinished) {
            System.out.println("Racing car " + racingNumber + " finished the stage!");
        } else {
            System.out.println("Racing car " + racingNumber + " DNF.");
        }

        System.out.println("Distance covered " + distance + " km.");
        print(matrix);

    }

    private static void fillTheMatrix(Scanner scanner, String[][] matrix,
                                      int[] firstEntryTunnel, int[] secondEntryTunnel) {
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            String input = scanner.nextLine();
            matrix[i] = input.split("\\s+");
            if (input.contains("T")) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j].equals("T")) {
                        if (counter == 0) {
                            firstEntryTunnel[0] = i;
                            firstEntryTunnel[1] = j;
                            counter++;
                        } else {
                            secondEntryTunnel[0] = i;
                            secondEntryTunnel[1] = j;
                        }
                    }
                }
            }
        }
    }

    private static void print(String[][] matrix) {
        for (String[] x : matrix) {
            for (String y : x) {
                System.out.print(y);
            }
            System.out.println();

        }
    }
}
