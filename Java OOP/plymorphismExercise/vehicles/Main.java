package plymorphismExercise.vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        vehicles.put("Car", getVehicle(scanner));
        vehicles.put("Truck", getVehicle(scanner));
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandLine = scanner.nextLine().split("\\s+");
//           Drive Car 9
//            Refuel Car 50
            String command = commandLine[0];
            String type = commandLine[1];
            Double argument = Double.parseDouble(commandLine[2]);
            switch (command) {
                case "Drive":
                    System.out.println(vehicles.get(type).drive(argument));
                    break;
                case "Refuel":
                    vehicles.get(type).refuel(argument);
            }
        }
        for (Map.Entry<String, Vehicle> entry : vehicles.entrySet()) {
            System.out.println(entry.getValue());
        }

    }

    private static Vehicle getVehicle(Scanner scanner) {
        VehicleImpl vehicle;
        String[] tokens = scanner.nextLine().split("\\s+");
        String type = tokens[0];
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);

        switch (type) {
            case "Car":
                vehicle = new Car(fuelQuantity, fuelConsumption);
                return vehicle;
            case "Truck":
                vehicle = new Truck(fuelQuantity, fuelConsumption);
                return vehicle;
            default:
                throw new IllegalArgumentException("No such type!");
        }


    }
}
