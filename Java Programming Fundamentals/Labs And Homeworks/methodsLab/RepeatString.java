package methodsLab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringInput = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        System.out.println(getRepeatingString(stringInput, count));

    }

    public static String getRepeatingString(String stringInput, int count) {
        String result = "";
        for (int i = 1; i <= count; i++) {
            result += stringInput;

        }
        return result;
    }
}
