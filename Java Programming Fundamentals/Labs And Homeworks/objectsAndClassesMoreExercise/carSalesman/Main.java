package objectsAndClassesMoreExercise.carSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linesOfEngines = Integer.parseInt(scanner.nextLine());
        List<Engine> engineList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();
        Engine engine = new Engine();
        for (int rows = 1; rows <= linesOfEngines; rows++) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input.length == 2) {
                engine = new Engine(input[0], Integer.parseInt(input[1]), 0, "n/a");
            } else if (input.length == 3) {
                if (isInteger(input[2])) {
                    engine = new Engine(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), "n/a");
                } else {
                    engine = new Engine(input[0], Integer.parseInt(input[1]), 0, input[2]);
                }
            } else {
                engine = new Engine(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), input[3]);
            }

            engineList.add(engine);
        }
        int lineForCars = Integer.parseInt(scanner.nextLine());
        Car car = new Car();
        for (int i = 1; i <= lineForCars; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String engineModel = input[1];
            if (getEngine(engineList, engineModel) != null) {
                engine = getEngine(engineList, engineModel);
            }
            if (input.length == 2) {
                car = new Car(input[0], engine, 0, "n/a");
            } else if (input.length == 3) {
                if (isInteger(input[2])) {
                    car = new Car(input[0], engine, Integer.parseInt(input[2]), "n/a");
                } else {
                    car = new Car(input[0], engine, 0, input[2]);
                }
            } else {
                car = new Car(input[0], engine, Integer.parseInt(input[2]), input[3]);
            }
            carList.add(car);
        }


        for (Car item : carList) {
            System.out.println(item.toString());

        }
    }

    public static boolean isInteger(String input) {
        Pattern pattern = Pattern.compile("[+-]?[0-9][0-9]*");
        return pattern.matcher(input).matches();
    }

    public static Engine getEngine(List<Engine> engineList, String model) {
        for (int j = 0; j < engineList.size(); j++) {
            Engine currentEngine = engineList.get(j);
            String currentModel = currentEngine.getModel();
            if (currentModel.equals(model)) {
                return currentEngine;
            }
        }
        return null;
    }
}