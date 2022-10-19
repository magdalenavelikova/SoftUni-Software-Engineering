package dataTypesAndVariables;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int digit = 0;
     //   boolean isSpecial = false;
        for (int ch = 1; ch <= n; ch++) {
            digit = ch;
            while (ch > 0) {
                sum += ch % 10;
                ch = ch / 10;
            }

            if((sum == 5) || (sum == 7) || (sum == 11)){
                System.out.printf("%d -> True%n", digit);
            }else {
                System.out.printf("%d -> False%n", digit);
            }


            sum = 0;
            ch = digit;
        }
    }
}
