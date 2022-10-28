package objectsAndClassesMoreExercise.rawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 1; i <= rows; i++) {
            String[] input = scanner.nextLine().split(" ");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            List<Tire> tireList = new ArrayList<>();
            for (int tireItems = 5; tireItems <= 12; tireItems += 2) {
                Tire currentTire = new Tire(Double.parseDouble(input[tireItems]), Integer.parseInt(input[tireItems + 1]));
                tireList.add(currentTire);
            }
            Car currentCar = new Car(model, engine, cargo, tireList);
            cars.add(currentCar);
        }

        String command = scanner.nextLine();
        switch (command) {
            case "fragile": //print all cars whose Cargo Type is "fragile" with a tire whose pressure is  < 1
                for (Car car : cars) {
                    Cargo cargo = car.getCargo();
                    String cargoType = cargo.getCargoType();
                    if (cargoType.equals("fragile")) {
                        List<Tire> tireList = car.getTires();
                        for (Tire tire : tireList) {
                            double pressure = tire.getPressure();
                            if (pressure < 1) {
                                System.out.println(car.getModel());
                                break;
                            }
                        }
                    }
                }
                break;

            case "flamable"://"flammable" print all cars whose Cargo Type is "flammable" and have Engine Power > 250.
                for (Car car : cars) {
                    Cargo cargo = car.getCargo();
                    String cargoType = cargo.getCargoType();
                    if (cargoType.equals("flamable")) {
                        Engine engine = car.getEngine();
                        int enginePower = engine.getEnginePower();
                        if (enginePower > 250) {
                            System.out.println(car.getModel());

                        }
                    }
                }

                break;
        }


    }

}
