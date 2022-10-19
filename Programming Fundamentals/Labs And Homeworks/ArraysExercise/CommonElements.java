package arraysExercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstRow = scanner.nextLine();
        String secondLine = scanner.nextLine();
        String[] firstLineArr = firstRow.split(" ");
        String[] secondRowArr = secondLine.split(" ");
        for (String secondElement : secondRowArr) {
            for (String firstElement : firstLineArr) {
                if (firstElement.equals(secondElement)) {
                    System.out.print(firstElement + " ");
                    break;
                }
            }

        }
    }
}
