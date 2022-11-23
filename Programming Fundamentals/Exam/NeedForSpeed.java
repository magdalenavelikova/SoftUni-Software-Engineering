package exam;

import java.util.*;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCar = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> carsMap = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCar; i++) {
            String input = scanner.nextLine();
            String car = input.split("\\|")[0];
            int mileage = Integer.parseInt(input.split("\\|")[1]);
            int fuel = Integer.parseInt(input.split("\\|")[2]);
            carsMap.putIfAbsent(car, new ArrayList<>());
            carsMap.get(car).add(mileage);
            carsMap.get(car).add(fuel);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
//•	"Drive : {car} : {distance} : {fuel}":
            String currentCommand = command.split(" : ")[0];
            String car = command.split(" : ")[1];
            int tankFuel = carsMap.get(car).get(1);
            int currentDistance = carsMap.get(car).get(0);
            switch (currentCommand) {
                case "Drive":
                    int distance = Integer.parseInt(command.split(" : ")[2]);
                    int neededFuel = Integer.parseInt(command.split(" : ")[3]);
                    if (tankFuel < neededFuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        tankFuel -= neededFuel;
                        currentDistance += distance;
                        carsMap.get(car).set(0, currentDistance);
                        carsMap.get(car).set(1, tankFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, neededFuel);
                        if (currentDistance >= 100000) {
                            System.out.printf("Time to sell the %s!%n",car);
                            carsMap.remove(car);
                        }
                    }

                    break;
                case "Refuel":
                    int fuel = Integer.parseInt(command.split(" : ")[2]);

                    if (tankFuel + fuel > 75) {
                        int refueledFuel = 75 - tankFuel;
                        carsMap.get(car).set(1, 75);
                        System.out.printf("%s refueled with %d liters%n", car, refueledFuel);

                    } else {
                        carsMap.get(car).set(1, tankFuel + fuel);
                        System.out.printf("%s refueled with %d liters%n", car, fuel);
                    }
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(command.split(" : ")[2]);
                    if (currentDistance - kilometers < 10000) {
                        carsMap.get(car).set(0, 10000);
                    } else {
                        currentDistance -= kilometers;
                        carsMap.get(car).set(0, currentDistance);
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }
            }
            command = scanner.nextLine();
        }

        carsMap.entrySet().forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", e.getKey(), e.getValue().get(0), e.getValue().get(1)));
    }
}
