package definingClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            Car car = new Car();
            car.setBrand(data[0]);
            car.setModel(data[1]);
            car.setHorsepower(Integer.parseInt(data[2]));
            carList.add(car);
        }
        carList.stream().forEach(e-> System.out.println(e.toString()));
    }

}
