package methodsLab;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Math.abs(Integer.parseInt(scanner.nextLine()));
        System.out.println(getMultiplyEvenByOdds(number));
    }

    private static int getMultiplyEvenByOdds(int number) {
        int sumEven = getSumEvenNumber(number);
        int sumOdd = getSumOddNumber(number);
        return sumEven * sumOdd;
    }

    private static int getSumEvenNumber(int number) {
        int sumEven = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 == 0) {
                sumEven += lastDigit;
            }
            number = number / 10;
        }
        return sumEven;
    }

    private static int getSumOddNumber(int number) {
        int sumOdd = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 != 0) {
                sumOdd += lastDigit;
            }
            number = number / 10;
        }
        return sumOdd;
    }
}
