package associativeArraysExercise;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        Map<String, Integer> quantityByResource = new LinkedHashMap<>();

        while (!inputLine.equals("stop")) {
            String resource = inputLine;
            int quantity = Integer.parseInt(scanner.nextLine());
            quantityByResource.putIfAbsent(resource, 0);
            int currentQuantity = quantityByResource.get(resource);
            quantityByResource.put(resource, currentQuantity + quantity);

            inputLine = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : quantityByResource.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
