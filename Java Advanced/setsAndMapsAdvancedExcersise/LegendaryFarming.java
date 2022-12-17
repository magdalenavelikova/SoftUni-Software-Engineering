package setsAndMapsAdvancedExcersise;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class LegendaryFarming {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        Map<String, Integer> quantityByMaterials = new TreeMap<>();
        Map<String, Integer> quantityByTrash = new TreeMap<>();
        quantityByMaterials.put("shards", 250);
        quantityByMaterials.put("fragments", 250);
        quantityByMaterials.put("motes", 250);
        boolean isObtained = false;

        while (!isObtained) {
            String[] inputArray = input.split("\\s+");

            for (int i = 0; i < inputArray.length; i += 2) {
                String currentMaterial = inputArray[i + 1];
                int quantity = Integer.parseInt(inputArray[i]);
                Integer quantityForMaterial = quantityByMaterials.get(currentMaterial);
                if (quantityForMaterial != null) {
                    quantityForMaterial -= quantity;

                    if (quantityForMaterial <= 0) {
                        System.out.println(getLegendaryItem(currentMaterial) + " obtained!");
                        quantityForMaterial = 250 - Math.abs(quantityForMaterial);
                        quantityByMaterials.put(currentMaterial, quantityForMaterial);
                        isObtained = true;
                        break;
                    } else {
                        quantityByMaterials.put(currentMaterial, quantityForMaterial);
                    }

                } else {
                    quantityByTrash.putIfAbsent(currentMaterial, 0);
                    int trashQuantity = quantityByTrash.get(currentMaterial);
                    quantityByTrash.put(currentMaterial, trashQuantity + quantity);
                }

            }
            if (!isObtained) {
                input = scanner.nextLine().toLowerCase();
            }
        }

        quantityByMaterials.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e->System.out.printf("%s: %d%n", e.getKey(), 250 - e.getValue()));

        for (Map.Entry<String, Integer> entry : quantityByTrash.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }


    }

    public static String getLegendaryItem(String material) {
        if (material.equals("shards")) {
            return "Shadowmourne";
        } else if (material.equals("fragments")) {
            return "Valanyr";
        } else {
            return "Dragonwrath";
        }
    }
}
