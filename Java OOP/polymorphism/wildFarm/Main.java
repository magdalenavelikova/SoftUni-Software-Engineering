package polymorphism.wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Animal> animalsList = new ArrayList<>();
        List<Food> foodList = new ArrayList<>();
        while (!input.equals("End")) {
            Animal animal = null;
            Food food;
            String[] tokens = input.split("\\s+");
            String[] foodInfo = scanner.nextLine().split("\\s+");
            String animalType = tokens[0];
            String animalName = tokens[1];
            Double animalWeight = Double.parseDouble(tokens[2]);
            String animalLivingRegion = tokens[3];
            switch (animalType) {
                case "Cat":
                    String breed = tokens[4];
                    animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, breed);
                    animalsList.add(animal);
                    break;
                case "Tiger":
                    animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                    animalsList.add(animal);
                    break;
                case "Mouse":
                    animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                    animalsList.add(animal);
                    break;
                case "Zebra":
                    animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                    animalsList.add(animal);
                    break;
                default:
                    System.out.println("No such typeOfAnimal");

            }

            food = getFood(foodInfo);
            foodList.add(food);

            input = scanner.nextLine();
        }
        for (int i = 0; i < animalsList.size(); i++) {
            animalsList.get(i).makeSound();
            animalsList.get(i).eat(foodList.get(i));

        }
        for (int i = 0; i < animalsList.size(); i++) {
            System.out.println(animalsList.get(i));
        }



    }

    private static Food getFood(String[] tokens) {
        Food food = null;
        String foodType = tokens[0];
        Integer foodQuantity = Integer.parseInt(tokens[1]);
        switch (foodType) {
            case "Vegetable":
                food = new Vegetable(foodQuantity);
                break;
            case "Meat":
                food = new Meat(foodQuantity);
                break;
            default:
                System.out.println("No such type of food!");
        }
        return food;
    }
}
