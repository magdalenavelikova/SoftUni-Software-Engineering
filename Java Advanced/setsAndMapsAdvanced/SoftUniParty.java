package setsAndMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> reservationSet = new TreeSet<>();
        while (!input.equals("PARTY")) {
            reservationSet.add(input);
            input= scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("END")) {
            reservationSet.remove(input);
            input = scanner.nextLine();
        }

        System.out.println(reservationSet.size());
        for (String s : reservationSet) {
            System.out.println(s);
        }

    }
}
