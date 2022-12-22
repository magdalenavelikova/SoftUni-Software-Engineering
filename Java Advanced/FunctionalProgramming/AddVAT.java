package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public class AddVAT {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] prices = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        UnaryOperator<Double> priceWithVat = p -> p * 1.2;

        System.out.println("Prices with VAT:");
        Arrays.stream(prices).forEach(p -> System.out.printf("%.2f%n", priceWithVat.apply(p)));

/* - CONSUMER
        DoubleUnaryOperator priceVat = p -> p * 1.2;
        Consumer<double[]> printPrice = p -> {
            Arrays.stream(p)
                    .map(priceVat)
                    .forEach(d -> System.out.printf("%.2f%n", d));
        };
        System.out.println("Prices with VAT:");
        printPrice.accept(prices);
*/
    }
}
