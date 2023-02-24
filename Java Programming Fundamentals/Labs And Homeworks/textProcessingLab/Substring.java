package textProcessingLab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringForRemove = scanner.nextLine();
        String input = scanner.nextLine();
        int index = input.indexOf(stringForRemove);
        while (index != -1) {
            input = input.replace(stringForRemove, "");
            index = input.indexOf(stringForRemove);
        }

        System.out.println(input);
    }
}
