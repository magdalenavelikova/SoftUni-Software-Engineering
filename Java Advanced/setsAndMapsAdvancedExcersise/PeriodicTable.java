package setsAndMapsAdvancedExcersise;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> periodicTable = new TreeSet<>();

        while (--n >= 0) {
            String[] element = scanner.nextLine().split("\\s+");
            for (String e : element) {
                periodicTable.add(e);
            }
        }

        periodicTable.forEach(e -> System.out.print(e + " "));
    }
}
