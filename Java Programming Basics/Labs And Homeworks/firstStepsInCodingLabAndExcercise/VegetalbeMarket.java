package firstStepsInCodingLabAndExcercise;

import java.util.Scanner;

public class VegetalbeMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pricePerVegetables = Double.parseDouble(scanner.nextLine());
        double pricePerFruit = Double.parseDouble(scanner.nextLine());
        int kgVegetables = Integer.parseInt(scanner.nextLine());
        int kgFruit = Integer.parseInt(scanner.nextLine());
        double amountVegetables = pricePerVegetables * kgVegetables;
        double amountFriuit = pricePerFruit * kgFruit;

        System.out.printf("%.2f", (amountFriuit + amountVegetables) / 1.94);


    }
}
