package multidimensionalArrays;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 8;
        char[][] chessBoard = new char[size][size];
        for (int r = 0; r < size; r++) {
            String string = scanner.nextLine().trim().replace(" ", "");
            chessBoard[r] = string.toCharArray();
        }

        int[] index = getIndexByRow(chessBoard);
        if (index[0] != -1) {
            String printLine = String.format("%d %d", index[0], index[1]);
            System.out.println(printLine);
        }
    }

    private static boolean searchInDiagonals(char[][] chessBoard, int[] index) {
        int counter = 1;
        int row = index[0] + 1;
        int col = index[1] + 1;

//        down+right
        while (row < chessBoard.length && col < chessBoard[row].length) {
            if (chessBoard[row][col] == 'q') {
                counter++;
            }
            row++;
            col++;
        }
//         down+left
        row = index[0] + 1;
        col = index[1] - 1;
        while (row < chessBoard.length && col >= 0) {
            if (chessBoard[row][col] == 'q') {
                counter++;
            }
            row++;
            col--;
        }
        row = index[0] - 1;
        col = index[1] - 1;

//        up+left
        while (row >= 0 && col >= 0) {
            if (chessBoard[row][col] == 'q') {
                counter++;
            }
            row--;
            col--;
        }
//       up+right
        row = index[0] - 1;
        col = index[1] + 1;
        while (row >= 0 && col < chessBoard[row].length) {
            if (chessBoard[row][col] == 'q') {
                counter++;
            }
            row--;
            col++;
        }

        return (counter == 1);
    }

    private static boolean searchInColumn(char[][] chessBoard, int[] index) {
        int row = 0;
        int col = index[1];
        int counter = 0;
        while (row < chessBoard.length) {
            char currentChar = chessBoard[row][col];
            if (currentChar == 'q') {
                counter++;
            }
            row++;
        }
        return (counter == 1);

    }

    private static int[] getIndexByRow(char[][] chessBoard) {
        int row = 0;
        int[] index = new int[2];
        while (row < chessBoard.length) {
            int col = 0;
            int counter = 0;
            while (col < chessBoard[row].length) {
                char currentChar = chessBoard[row][col];
                if (currentChar == 'q') {
                    index[0] = row;
                    index[1] = col;
                    counter++;
                }
                col++;
            }
            if (counter == 1) {
                boolean isOneQueenInColumn = searchInColumn(chessBoard, index);
                boolean isOneQueenInDiagonal = searchInDiagonals(chessBoard, index);
                if (isOneQueenInColumn && isOneQueenInDiagonal) {
                    return index;
                }
            }
            row++;
        }

        index[0] = -1;
        index[1] = -1;
        return index;
    }
}
