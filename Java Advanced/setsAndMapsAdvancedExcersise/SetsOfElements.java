package setsAndMapsAdvancedExcersise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int firstSetLength = Integer.parseInt(input.split("\\s+")[0]);
        int secondSetLength = Integer.parseInt(input.split("\\s+")[1]);
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        while (--firstSetLength >= 0) {
            Integer firstSetNumber = Integer.parseInt(scanner.nextLine());
            firstSet.add(firstSetNumber);
        }

        while (--secondSetLength >= 0) {
            Integer secondSetNumber = Integer.parseInt(scanner.nextLine());
            secondSet.add(secondSetNumber);
        }
        firstSet.retainAll(secondSet);

        firstSet.forEach(e -> System.out.print(e + " "));

        /*for (Integer entryFirstSet : firstSet) {
            for (Integer entrySecondSet : secondSet) {
                if (entryFirstSet.equals(entrySecondSet)) {
                    System.out.print(entrySecondSet + " ");
                }
            }
        }*/

    }
}
