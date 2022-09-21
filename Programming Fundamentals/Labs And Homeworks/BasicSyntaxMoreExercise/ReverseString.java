package BasicSyntaxMoreExercise;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        for (int i = inputLine.length() - 1; i >= 0; i--) {

            System.out.print(inputLine.charAt(i));

        }
    }
}
