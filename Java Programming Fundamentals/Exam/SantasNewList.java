package exam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SantasNewList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> amountsByChildName = new TreeMap<>();
        Map<String, Integer> amountsByTypeOfToy = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            if (!input.contains("Remove")) {
                String childName = input.split("->")[0];
                String typeOfToy = input.split("->")[1];
                int amount = Integer.parseInt(input.split("->")[2]);
                if (amountsByChildName.containsKey(childName)) {
                    int currentAmount = amountsByChildName.get(childName);
                    amountsByChildName.put(childName, amount + currentAmount);
                } else {
                    amountsByChildName.put(childName, amount);
                }
                if (amountsByTypeOfToy.containsKey(typeOfToy)) {
                    int currentAmount = amountsByTypeOfToy.get(typeOfToy);
                    amountsByTypeOfToy.put(typeOfToy, amount + currentAmount);
                } else {
                    amountsByTypeOfToy.put(typeOfToy, amount);
                }
            } else {
                String childName = input.split("->")[1];
                amountsByChildName.remove(childName);
            }
            input = scanner.nextLine();
        }
        Map<String, Integer> sortedByAmounts = new LinkedHashMap<>();
        amountsByChildName.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .forEachOrdered(x -> sortedByAmounts.put(x.getKey(), x.getValue()));

        System.out.println("Children:");
        for (Map.Entry<String, Integer> entry : sortedByAmounts.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Presents:");
        for (Map.Entry<String, Integer> entry : amountsByTypeOfToy.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
