package еncapsulationExercise.shoppingSpree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] personInfo = scanner.nextLine().split(";");
        Map<String, Person> peopleMap = new LinkedHashMap<>();

        for (String info : personInfo) {
            String name = info.split("=")[0];
            double money = Double.parseDouble(info.split("=")[1]);
            try {
                Person person = new Person(name, money);
                peopleMap.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        Map<String, Product> productMap = new HashMap<>();
        String[] productInfo = scanner.nextLine().split(";");

        for (String info : productInfo) {
            String name = info.split("=")[0];
            double cost = Double.parseDouble(info.split("=")[1]);
            try {
                Product product = new Product(name, cost);
                productMap.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String personName = input.split("\\s+")[0];
            String productName = input.split("\\s+")[1];

            if (peopleMap.containsKey(personName) && productMap.containsKey(productName)) {
                Person currentPerson = peopleMap.get(personName);
                Product currentProduct = productMap.get(productName);
                try {
                    currentPerson.buyProduct(currentProduct);
                    System.out.printf("%s bought %s%n", personName, productName);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            input = scanner.nextLine();
        }

        peopleMap.values().forEach(System.out::println);
    }
}
