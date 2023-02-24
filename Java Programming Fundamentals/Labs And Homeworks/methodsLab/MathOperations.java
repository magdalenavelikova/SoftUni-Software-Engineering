package methodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber = Double.parseDouble(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        double secondNumber = Double.parseDouble(scanner.nextLine());
        DecimalFormat format = new DecimalFormat("0.##");
        double result = getResultFromMathOperations(firstNumber, operator, secondNumber);
        System.out.print(format.format(result));
    }

    private static double getResultFromMathOperations(double n1, char sign, double n2) {
        double result = 0;
        switch (sign) {
            case '/':
                result = n1 / n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;

        }
        return result;
    }
}
