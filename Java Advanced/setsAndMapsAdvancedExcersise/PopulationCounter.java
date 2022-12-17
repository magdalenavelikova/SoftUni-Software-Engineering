package setsAndMapsAdvancedExcersise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Long>> populationsByCountries = new LinkedHashMap<>();
        LinkedHashMap<String, Long> totalPopulationByCountries = new LinkedHashMap<>();
        while (!input.equals("report")) {
            String city = input.split("\\|")[0];
            String country = input.split("\\|")[1];
            Long population = Long.parseLong(input.split("\\|")[2]);
            if (totalPopulationByCountries.containsKey(country)) {
                totalPopulationByCountries.put(country, totalPopulationByCountries.get(country) + population);
            } else {
                totalPopulationByCountries.put(country, population);
            }
            populationsByCountries.putIfAbsent(country, new LinkedHashMap<>());
            populationsByCountries.get(country).put(city, population);

            input = scanner.nextLine();
        }


        totalPopulationByCountries.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed())
                .forEach(e -> {
                    System.out.println(e.getKey() + " (total population: " + e.getValue() + ")");
                    String country = e.getKey();
                    populationsByCountries.get(country).entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue()
                                    .reversed())
                            .forEach(city -> System.out.println("=>" + city.getKey() + ": " + city.getValue()));
                });

    }

}
