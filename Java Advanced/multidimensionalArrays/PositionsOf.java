package multidimensionalArrays;

import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int[][] matrix = new int[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                matrix[r][c] = scanner.nextInt();
            }
        }
        int searchingNumber = scanner.nextInt();
        boolean isExist = false;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (matrix[r][c] == searchingNumber) {
                    System.out.println(r + " " + c);
                    isExist=true;
                }
            }
        }
        if(!isExist){
            System.out.println("not found");
        }
    }
}
