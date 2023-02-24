package exam;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Integer>> citiesMap = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Sail")) {
            String city = input.split("\\|\\|")[0];
            int population = Integer.parseInt(input.split("\\|\\|")[1]);
            int gold = Integer.parseInt(input.split("\\|\\|")[2]);
            if (citiesMap.containsKey(city)){
                int currentPopulation=citiesMap.get(city).get(0)+population;
                int currentGold=citiesMap.get(city).get(1)+gold;
                citiesMap.get(city).set(0, currentPopulation);
                citiesMap.get(city).set(1, currentGold);
            }else {
                citiesMap.put(city, new ArrayList<>());
                citiesMap.get(city).add(population);
                citiesMap.get(city).add(gold);
            }
            input = scanner.nextLine();
        }
        String events = scanner.nextLine();
        while (!events.equals("End")) {
            String command = events.split("=>")[0];
            String town = events.split("=>")[1];
            if (command.equals("Prosper")) {
                int gold = Integer.parseInt(events.split("=>")[2]);
                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    int reservedGold = citiesMap.get(town).get(1);
                    citiesMap.get(town).set(1, reservedGold + gold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, gold + reservedGold);
                }

            } else if (command.equals("Plunder")) {
                int people = Integer.parseInt(events.split("=>")[2]);
                int gold = Integer.parseInt(events.split("=>")[3]);
                int restOfCitizens = citiesMap.get(town).get(0) - people;
                int restOfGold = citiesMap.get(town).get(1) - gold;
                citiesMap.get(town).set(0, restOfCitizens);
                citiesMap.get(town).set(1, restOfGold);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                if (restOfGold == 0 || restOfCitizens == 0) {
                    citiesMap.remove(town);
                    System.out.println(town + " has been wiped off the map!");
                }
            }

            events = scanner.nextLine();
        }
        if (citiesMap.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %s wealthy settlements to go to:%n", citiesMap.size());
            for (Map.Entry<String, List<Integer>> entry : citiesMap.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
            }

        }

    }
}
