package ExamineЕxercise2;

import java.util.Scanner;

public class BarcodeGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        String end = scanner.nextLine();

        int firstDigit = Integer.parseInt("" + start.charAt(0));
        int secondDigit = Integer.parseInt("" + start.charAt(1));
        int thirdDigit = Integer.parseInt("" + start.charAt(2));
        int fourthDigit = Integer.parseInt("" + start.charAt(3));
        int firstDigitEnd = Integer.parseInt("" + end.charAt(0));
        int secondDigitEnd = Integer.parseInt("" + end.charAt(1));
        int thirdDigitEnd = Integer.parseInt("" + end.charAt(2));
        int fourthDigitEnd = Integer.parseInt("" + end.charAt(3));
        for (int i = firstDigit; i <= firstDigitEnd; i++) {
            if (i % 2 != 0) {
           //   /  System.out.print(i);
                for (int j = secondDigit; j <= secondDigitEnd; j++) {
                    if (j % 2 != 0) {
                     //   System.out.print(j);
                        for (int k = thirdDigit; k <= thirdDigitEnd; k++) {
                            if (k % 2 != 0) {
                        //        System.out.print(k);
                                for (int l = fourthDigit; l <= fourthDigitEnd; l++) {
                                    if (l % 2 != 0) {
                                        System.out.print(i);
                                        System.out.print(j);
                                        System.out.print(k);
                                        System.out.print(l);
                                        System.out.print(" ");
                                    }

                                }
                            }

                        }
                    }

                }
            }

        }

    }

}



