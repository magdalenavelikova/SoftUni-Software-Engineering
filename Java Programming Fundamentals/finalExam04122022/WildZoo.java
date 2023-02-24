package finalExam;

import java.util.*;

public class WildZoo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> animals = new LinkedHashMap<>();
        Map<String, List<String>> areas = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("EndDay")) {
            String command = input.split(":")[0];
            String animalName = input.split(":")[1].split("-")[0].trim();
            int food = Integer.parseInt(input.split(":")[1].split("-")[1]);

            if (command.equals("Add")) {
                String area = input.split(":")[1].split("-")[2];
                if (animals.containsKey(animalName)) {
                    int currentFood = animals.get(animalName);
                    animals.put(animalName, currentFood + food);
                } else {
                    animals.put(animalName, food);
                }
                if (areas.containsKey(area)) {
                    if (!areas.get(area).contains(animalName)) {
                        areas.get(area).add(animalName);
                    }
                } else {
                    areas.put(area, new ArrayList<>());
                    areas.get(area).add(animalName);
                }

            } else if (command.equals("Feed")) {
                if (animals.containsKey(animalName)) {
                    int currentFood = animals.get(animalName);
                    if (currentFood - food <= 0) {
                        System.out.println(animalName + " was successfully fed");
                        animals.remove(animalName);
                        for (Map.Entry<String, List<String>> entry : areas.entrySet()) {
                            for (int i = 0; i < entry.getValue().size(); i++) {
                                if (entry.getValue().get(i).equals(animalName)) {
                                    entry.getValue().remove(i);
                                }
                            }
                        }

                    } else {
                        animals.put(animalName, currentFood - food);
                    }
                }

            }
            input = scanner.nextLine();
        }

        System.out.println("Animals:");
        for (Map.Entry<String, Integer> entry : animals.entrySet()) {
            System.out.println(" " + entry.getKey() + " -> " + entry.getValue() + "g");
        }
        System.out.println("Areas with hungry animals:");
        for (Map.Entry<String, List<String>> entry : areas.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                System.out.println(" " + entry.getKey() + ": " + entry.getValue().size());
            }
        }


    }
}
