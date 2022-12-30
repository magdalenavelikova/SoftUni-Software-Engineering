package definingClassesExercise.carSalesman;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());

        Map<String, Engine> engineMap = new HashMap<>();

        while (row-- > 0) {
            Engine engine = null;
            String[] data = scanner.nextLine().split("\\s+");
            if (data.length == 4) {
                engine = new Engine(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3]);
            } else if (data.length == 2) {
                engine = new Engine(data[0], Integer.parseInt(data[1]));
            } else if (data.length == 3) {
                if (Character.isDigit(data[2].charAt(0))) {
                    engine = new Engine(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                } else {
                    engine = new Engine(data[0], Integer.parseInt(data[1]), data[2]);
                }
            }
            engineMap.put(data[0], engine);
        }
        int rowsForCars = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();

        while (rowsForCars-- > 0) {

            String[] carInfo = scanner.nextLine().split("\\s+");
            String engineModel = carInfo[1];
            Engine currentEngine = engineMap.get(engineModel);
            Car car = null;
            if (carInfo.length == 4) {
                car = new Car(carInfo[0], currentEngine, Integer.parseInt(carInfo[2]), carInfo[3]);
            } else if (carInfo.length == 2) {
                car = new Car(carInfo[0], currentEngine);
            } else if ((carInfo.length == 3)) {
                if (Character.isDigit(carInfo[2].charAt(0))) {
                    car = new Car(carInfo[0], currentEngine, Integer.parseInt(carInfo[2]));
                } else {
                    car = new Car(carInfo[0], currentEngine, carInfo[2]);
                }

            }
            carList.add(car);
        }


        carList.forEach(e -> System.out.println(e.toString()));

    }
}
