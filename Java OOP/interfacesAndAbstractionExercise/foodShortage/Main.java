package interfacesAndAbstractionExercise.foodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> nameByBuyers = new HashMap<>();
        Buyer buyer;
        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            if (tokens.length == 3) {
                String group = tokens[2];
                buyer = new Rebel(name, age, group);
            } else  {
                String id = tokens[2];
                String birthDate = tokens[3];
                buyer = new Citizen(name, age, id, birthDate);
            }

            nameByBuyers.put(name, buyer);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            if (nameByBuyers.containsKey(input)) {
                nameByBuyers.get(input).buyFood();
            }
            input = scanner.nextLine();
        }
        int sumOfFood = nameByBuyers.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(sumOfFood);

    }

}
