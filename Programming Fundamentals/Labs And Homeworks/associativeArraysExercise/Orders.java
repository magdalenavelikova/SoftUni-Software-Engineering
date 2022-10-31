package associativeArraysExercise;

import java.util.*;
import java.util.stream.Collectors;


public class Orders {
    static class Product {
        private String name;
        private double price;
        private int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getTotalPrice() {
            return String.format("%.2f", quantity * price);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        Map<String, Product> productMap = new LinkedHashMap<>();

        while (!inputLine.equals("buy")) {
            String productName = inputLine.split(" ")[0];
            Double price = Double.parseDouble(inputLine.split(" ")[1]);
            int quantity = Integer.parseInt(inputLine.split(" ")[2]);
            Product product = productMap.get(productName);
            if (product != null) {
                if (price != product.getPrice()) {
                    product.setPrice(price);
                }
                quantity += product.getQuantity();
                product.setQuantity(quantity);

            } else {
                product = new Product(productName, price, quantity);
                productMap.put(productName, product);
            }

            inputLine = scanner.nextLine();
        }
        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().getTotalPrice());

        }


    }
}
