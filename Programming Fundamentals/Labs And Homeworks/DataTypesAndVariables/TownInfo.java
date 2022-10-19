package dataTypesAndVariables;

import java.util.Scanner;

public class TownInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        the name of the town, on the second – the population, and on the third – the area
        String nameOfTown = scanner.nextLine();
        int population = Integer.parseInt(scanner.nextLine());
        int area = Integer.parseInt(scanner.nextLine());
        System.out.printf("Town %s has population of %d and area %d square km.", nameOfTown, population, area);
    }
}
