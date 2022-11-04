package textProcessingExercise;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstNumber = scanner.nextLine().replaceFirst("^0+(?!$)", "");
        int secondNumber = Integer.parseInt(scanner.nextLine());
        StringBuilder multiply = new StringBuilder();
        int overage = 0;
        if (secondNumber != 0) {
            for (int i = firstNumber.length() - 1; i >= 0; i--) {
                int currentDigit = Character.getNumericValue(firstNumber.charAt(i));
                int product = (currentDigit * secondNumber) + overage;
                if (product > 9) {
                    overage = product / 10;
                    product = product % 10;
                    multiply.append(product);
                } else {
                    overage = 0;
                    multiply.append(product);
                }
            }
            if (overage > 0) {
                multiply.append(overage);
            }

            multiply.reverse();
            System.out.println(multiply);
        } else {
            System.out.println(0);
        }

    }
}
