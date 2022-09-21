package ArraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] numberArr = new int[n];
        for (int i = 0; i < n; i++) {
            String inputLine = scanner.nextLine();
            int sum = 0;
            for (int j = 0; j < inputLine.length(); j++) {
                char ch = inputLine.charAt(j);
                int chASCII = 0;
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                    chASCII = ch;
                    sum += chASCII * inputLine.length();
                } else {
                    chASCII = ch;
                    sum += chASCII / (inputLine.length());
                }
            }
            numberArr[i] = sum;

        }
        Arrays.sort(numberArr);
        for (int i = 0; i < numberArr.length; i++) {
            System.out.println(numberArr[i]);

        }


    }
}
