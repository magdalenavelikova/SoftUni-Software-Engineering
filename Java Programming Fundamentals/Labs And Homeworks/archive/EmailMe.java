package archive;

import java.util.Scanner;

public class EmailMe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        String firstPart = email.split("@")[0];
        String secondPart = email.split("@")[1];
        int firstSum = getSumOfCharacters(firstPart);
        int secondSum = getSumOfCharacters(secondPart);
        int result = firstSum - secondSum;
        if (result >= 0) {
            System.out.println("Call her!");
        } else {
            System.out.println("She is not the one.");
        }
    }

    private static int getSumOfCharacters(String string) {
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            int number = string.charAt(i);
            sum += number;

        }
        return sum;
    }
}
