package ArraysExercise;

import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lineArray = scanner.nextLine().split(" ");
        int rotation = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= rotation; i++) {
            String firstElement = lineArray[0];
            for (int j = 0; j < lineArray.length - 1; j++) {
                lineArray[j] = lineArray[j + 1];
            }
            lineArray[lineArray.length - 1] = firstElement;
        }
        for (int i = 0; i < lineArray.length; i++) {
            System.out.print(lineArray[i] + " ");
        }

    }
}
