package definingClassesExercise.speedRacing;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carCount = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carMap = new LinkedHashMap<>();

        while (carCount-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            Car car = new Car(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]));
            carMap.put(data[0], car);
        }
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] command = input.split("\\s+");
            String model = command[1];
            int amountOfKm = Integer.parseInt(command[2]);

            carMap.get(model).drive(amountOfKm);

            input = scanner.nextLine();
        }
        carMap.forEach((key, value) -> System.out.println(value.toString()));
    }
}
