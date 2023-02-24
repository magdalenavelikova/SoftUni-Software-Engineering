package associativeArraysMoreExercise;

import java.util.*;

public class Snowwhite {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        Map<String, Integer> physicsByNameAndColour = new LinkedHashMap<>();
        Map<Integer, List<String>> nameAndColourByPhysics = new TreeMap<>(Comparator.reverseOrder());
        Map<String, Integer> countByHat = new TreeMap<>(Comparator.reverseOrder());
        while (!inputLine.equals("Once upon a time")) {
            String name = inputLine.split("\\s+<:>\\s+")[0];
            String hat = inputLine.split("\\s+<:>\\s+")[1];
            int physics = Integer.parseInt(inputLine.split("\\s+<:>\\s+")[2]);
            String currentDescription = name + " " + hat;
            physicsByNameAndColour.putIfAbsent(currentDescription, physics);
            countByHat.putIfAbsent(hat, 0);
            if (physicsByNameAndColour.get(currentDescription) < physics) {
                physicsByNameAndColour.put(currentDescription, physics);
            } else {
                int counter = countByHat.get(hat) + 1;
                countByHat.put(hat, counter);
            }
            inputLine = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : physicsByNameAndColour.entrySet()) {
            nameAndColourByPhysics.putIfAbsent(entry.getValue(), new ArrayList<>());
            nameAndColourByPhysics.get(entry.getValue()).add(entry.getKey());
        }

        for (Map.Entry<Integer, List<String>> entry : nameAndColourByPhysics.entrySet()) {
            entry.getValue().stream().sorted(
                    (s1, s2) -> {
                        String color1 = s1.split("\\s+")[1];
                        String color2 = s2.split("\\s+")[1];
                        Integer count1 = countByHat.get(color1);
                        Integer count2 = countByHat.get(color2);
                        return Integer.compare(count2, count1);
                    }
            ).forEach(s -> {
                        String name = s.split("\\s+")[0];
                        String hatColour = s.split("\\s+")[1];
                        System.out.printf("(%s) %s <-> %d%n", hatColour, name, entry.getKey());
                    }
            );

        }
    }
}
