package JavaConditionalStatements;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//⦁	N1 – цяло число в интервала [0...40 000]
//⦁	N2 – цяло число в интервала [0...40 000]
//⦁	Оператор – един символ измеду: "+", "-", "*", "/", "%"
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        double result = 0.0;

        if ("+".equals(operator)) {
            result = n1 + n2;
        } else if ("-".equals(operator)) {
            result = n1 - n2;
        } else if ("*".equals(operator)) {
            result = n1 * n2;
        } else if ("%".equals(operator) && n2 > 0) {
            result = n1 % n2;
        } else if ("/".equals(operator) && n2 > 0) {
            result = (double) (n1 * 1.0 / n2 * 1.0);

        }

        boolean isEven = result % 2 == 0;


        if ("+".equals(operator) || "-".equals(operator) || "*".equals(operator)) {
            System.out.printf("%d %s %d = ", n1, operator, n2);
            System.out.printf("%.0f", result);
            if (isEven) {
                System.out.println(" - even");
            } else {
                System.out.println(" - odd");
            }
        } else if ("%".equals(operator) && n2 > 0) {
            System.out.printf("%d %s %d = ", n1, operator, n2);
            System.out.printf("%.0f", result);

        } else if ("/".equals(operator) && n2 > 0) {
            System.out.printf("%d %s %d = ", n1, operator, n2);
            System.out.printf("%.2f", result);

        } else if (n2 == 0 && ("/".equals(operator) || "%".equals(operator))) {
            System.out.printf("Cannot divide %d by zero", n1);
        }


    }
}
