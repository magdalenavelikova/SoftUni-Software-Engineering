package setsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Set<String> parking = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String direction = input.split(", ")[0];
            String carNumber = input.split(", ")[1];
            input = scanner.nextLine();
            if(direction.equals("IN")){
                parking.add(carNumber);
            } else if (direction.equals("OUT")) {
                parking.remove(carNumber);
            }
        }

        System.out.println(parking.isEmpty()
                ? "Parking Lot is Empty"
                : String.join(System.lineSeparator(), parking));

    }
}
