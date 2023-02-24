package nestedLoopsLabAndExcercise;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int lastNumber = Integer.parseInt(scanner.nextLine());
        for (int i = firstNumber; i <= lastNumber; i++) {
            String currentNum = "" + i;
            int sumEven = 0;
            int sumOdd = 0;
            for (int j = 0; j < currentNum.length(); j++) {
                int currentDigit = Integer.parseInt("" + currentNum.charAt(j));
                if ((j + 1) % 2 == 0) {
                    sumEven += currentDigit;
                } else {
                    sumOdd += currentDigit;
                }

            }
            if (sumEven==sumOdd) {
//                System.out.println(currentNum);
                System.out.printf("%s ",currentNum);
            }
        }

    }
}
