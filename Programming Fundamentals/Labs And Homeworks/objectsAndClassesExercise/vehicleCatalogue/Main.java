package objectsAndClassesExercise.vehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        List<Vehicle> vehiclesList = new ArrayList<>();
        while (!inputLine.equals("End")) {
            String type = inputLine.split(" ")[0];
            String model = inputLine.split(" ")[1];
            String color = inputLine.split(" ")[2];
            int horsepower = Integer.parseInt(inputLine.split(" ")[3]);
            Vehicle vehicle = new Vehicle(type, model, color, horsepower);
            vehiclesList.add(vehicle);
            inputLine = scanner.nextLine();
        }
        String model = scanner.nextLine();
        while (!model.equals("Close the Catalogue")) {
            for (Vehicle vehicle : vehiclesList) {
                if (model.equals(vehicle.getModel())) {
                    String type=vehicle.getType().substring(0, 1).toUpperCase() + vehicle.getType().substring(1);
                    System.out.println("Type: " + type);
                    System.out.println("Model: " + vehicle.getModel());
                    System.out.println("Color: " + vehicle.getColor());
                    System.out.println("Horsepower: " + vehicle.getHorsepower());
                    break;
                }
            }
            model = scanner.nextLine();
        }
        double averageHorsepowerCars = getAverageHorsepower(vehiclesList, "car");
        double averageHorsepowerTruck = getAverageHorsepower(vehiclesList, "truck");
        System.out.printf("Cars have average horsepower of: %.2f.%n", averageHorsepowerCars);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", averageHorsepowerTruck);

    }

    public static double getAverageHorsepower(List<Vehicle> vehicles, String type) {
        int sum = 0;
        int counter = 0;

        for (Vehicle vehicle : vehicles) {
            if (type.equals(vehicle.getType())) {
                sum += vehicle.getHorsepower();
                counter++;
            }
        }
        if (counter>0) {
            return sum * 1.0 / counter;
        }else {
            return 0.0;

        }
    }
}
