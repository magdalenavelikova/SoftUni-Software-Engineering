package exam;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> rarityByPlants = new LinkedHashMap<>();

        for (int i = 0; i < rows; i++) {
            String input = scanner.nextLine();
            String plant = input.split("<->")[0];
            String rarity = input.split("<->")[1];
            rarityByPlants.putIfAbsent(plant, new ArrayList<>());
            if (rarityByPlants.get(plant).isEmpty()) {
                rarityByPlants.get(plant).add(rarity);
            } else {
                rarityByPlants.get(plant).set(0, rarity);
            }
        }
        String commands = scanner.nextLine();
        while (!commands.equals("Exhibition")) {
            String currentCommand = commands.split(":\\s+")[0];
            String plant = commands.split(": ")[1].split(" - ")[0];
            if (rarityByPlants.containsKey(plant)) {
                switch (currentCommand) {
                    case "Rate":
                        String rating = commands.split(":\\s+")[1].split(" - ")[1];
                        rarityByPlants.get(plant).add(rating);
                        break;
                    case "Update":
                        String new_rarity = commands.split(":\\s+")[1].split(" - ")[1];
                        rarityByPlants.get(plant).set(0, new_rarity);
                        break;
                    case "Reset":
                        String currentRarity = rarityByPlants.get(plant).get(0);
                        rarityByPlants.get(plant).clear();
                        rarityByPlants.get(plant).add(currentRarity);
                        break;
                }

            } else {
                System.out.println("error");
            }
            commands = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, List<String>> entry : rarityByPlants.entrySet()) {
            double rating = 0;
            double averageRating = 0;
            if (entry.getValue().size() > 1) {
                for (int i = 1; i < entry.getValue().size(); i++) {
                    rating += Double.parseDouble(entry.getValue().get(i));
                }
                averageRating = rating / (entry.getValue().size() - 1);
            }

            System.out.printf("- %s; Rarity: %s; Rating: %.2f%n", entry.getKey(), entry.getValue().get(0), averageRating);
        }


    }
}
