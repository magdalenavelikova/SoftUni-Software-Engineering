package multidimensionalArrays;

import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int[][] firstMatrix = new int[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                firstMatrix[r][c] = scanner.nextInt();
            }
        }
        row = scanner.nextInt();
        column = scanner.nextInt();
        int[][] secondMatrix = new int[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                secondMatrix[r][c] = scanner.nextInt();
            }
        }
        boolean areEqual=false;
        if (firstMatrix.length == secondMatrix.length) {
             areEqual=areMatrixEqual(firstMatrix, secondMatrix);
        }
        if(areEqual){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }

    }
private static boolean areMatrixEqual(int[][] firstMatrix, int[][] secondMatrix){
    for (int row = 0; row < firstMatrix.length ; row++) {
        int[] firstArray=firstMatrix[row];
        int[] secondArray=secondMatrix[row];
        if (firstArray.length!=secondArray.length){
            return false;
        }else {
            for (int i = 0; i < firstArray.length; i++) {
                if(firstArray[i]!=secondArray[i]){
                    return false;
                }
            }
        }
    }
     return true;
}
}
