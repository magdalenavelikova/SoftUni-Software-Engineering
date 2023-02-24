package textProcessingMoreExercise;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstChar = scanner.nextLine().charAt(0);
        int secondChar = scanner.nextLine().charAt(0);
        String text = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) > firstChar && text.charAt(i) < secondChar) {
                sum += text.charAt(i);
            }
        }
        System.out.println(sum);

    }
}
