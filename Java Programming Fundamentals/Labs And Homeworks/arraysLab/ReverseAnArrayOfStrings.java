package arraysLab;

import java.util.Scanner;

public class ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLineArr = scanner.nextLine().split(" ");
        for (int i = 0; i < inputLineArr.length / 2; i++) {
            String oldElement = inputLineArr[i];
            inputLineArr[i] = inputLineArr[inputLineArr.length - 1 - i];
            inputLineArr[inputLineArr.length - 1 - i] = oldElement;
        }
        System.out.println(String.join(" ", inputLineArr));

    }
}
