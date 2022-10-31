package associativeArraysExercise;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        Map<String, Integer> quantityByMaterials = new LinkedHashMap<>();
        Map<String, Integer> quantityByTrash = new LinkedHashMap<>();
        quantityByMaterials.put("shards", 250);
        quantityByMaterials.put("fragments", 250);
        quantityByMaterials.put("motes", 250);
        boolean isObtained = false;
        while (isObtained == false) {
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
            if (isObtained == false) {
                input = scanner.nextLine().toLowerCase();
            }
        }

        for (Map.Entry<String, Integer> entry : quantityByMaterials.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), 250 - entry.getValue());

        }
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
