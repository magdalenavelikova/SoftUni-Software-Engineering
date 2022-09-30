package MethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        DecimalFormat format = new DecimalFormat("0.#######");
        System.out.println(format.format(getMathPower(number, power)));
    }

    private static double getMathPower(double number, int power) {
        return Math.pow(number, power);
    }
}
