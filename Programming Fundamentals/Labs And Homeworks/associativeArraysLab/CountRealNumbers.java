package associativeArraysLab;

import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        Map<Double, Integer> counterByNumbers = new TreeMap<>();
        for (Double number : numbers) {
            counterByNumbers.putIfAbsent(number, 0);
            int counter = counterByNumbers.get(number);
            if (counter == 0) {
                counterByNumbers.put(number, 1);
            } else {
                counterByNumbers.put(number, counter + 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : counterByNumbers.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }


    }
}
