package setsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Double> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble).collect(Collectors.toList());

        Map<Double, Integer> counterByNumbers = new LinkedHashMap<>();

        for (Double entry : list) {
            if (!counterByNumbers.containsKey(entry)) {
                counterByNumbers.put(entry, 1);
            } else {
                int counter = counterByNumbers.get(entry);
                counterByNumbers.put(entry, counter + 1);
            }

        }

        for (Map.Entry<Double, Integer> entry : counterByNumbers.entrySet()) {
            String output = String.format("%.1f -> %d", entry.getKey(), entry.getValue());
            System.out.println(output);
        }

    }
}
