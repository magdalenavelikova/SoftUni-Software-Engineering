package multidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        int[][] matrix = new int[r][c];

        fillMatrix(scanner, matrix, r);

        printReversedDiagonal(matrix, r, c);


    }

    private static void printReversedDiagonal(int[][] matrix, int r, int c) {
        for (int row = r - 1; row >= 0; row--) {

            if (row == r - 1) {
                for (int col = c - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col] + " ");
                    int dr = row;
                    int dc = col;
                    while (dr - 1 >= 0 && dc + 1 <= c - 1) {
                        System.out.print(matrix[dr - 1][dc + 1] + " ");
                        dr--;
                        dc++;
                    }
                    System.out.println();
                }
            } else {

                for (int col = 0; col < c; col++) {

                    System.out.print(matrix[row][col] + " ");
                    int dr = row;
                    int dc = col;
                    while (dr - 1 >= 0 && dc + 1 <= c - 1) {
                        System.out.print(matrix[dr - 1][dc + 1] + " ");
                        dr--;
                        dc++;

                    }
                    System.out.println();
                    col = c;
                }

            }
            }
        }

            private static void fillMatrix (Scanner scanner,int[][] matrix, int r){

                for (int i = 0; i < r; i++) {
                    matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .mapToInt(Integer::parseInt).toArray();

                }
            }


        }
