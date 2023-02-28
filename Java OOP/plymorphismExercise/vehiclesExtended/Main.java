package plymorphismExercise.vehiclesExtended;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        vehicles.put("Car", getVehicle(scanner));
        vehicles.put("Truck", getVehicle(scanner));
        vehicles.put("Bus", getVehicle(scanner));
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandLine = scanner.nextLine().split("\\s+");
            String command = commandLine[0];
            String type = commandLine[1];
            Double argument = Double.parseDouble(commandLine[2]);
            switch (command) {
                case "Drive":
                    System.out.println(vehicles.get(type).driveAC(argument));
                    break;
                case "Refuel":
                    try {
                        vehicles.get(type).refuel(argument);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    System.out.println(vehicles.get(type).drive(argument));
                    break;
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
        double tankCapacity = Double.parseDouble(tokens[3]);

        switch (type) {
            case "Car":
                vehicle = new Car(fuelQuantity, fuelConsumption, tankCapacity);
                return vehicle;
            case "Truck":
                vehicle = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
                return vehicle;
            case "Bus":
                vehicle = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
                return vehicle;
            default:
                throw new IllegalArgumentException("No such type!");
        }


    }
}
