package DataTypesAndVariables;

import java.util.Scanner;

public class PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1 British Pound = 1.36 Dollars
        double pound = Double.parseDouble(scanner.nextLine());
        System.out.printf("%.3f", pound * 1.36);
    }
}
