package setsAndMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> reservationsSet = new TreeSet<>();

        while (!input.equals("PARTY")) {
            reservationsSet.add(input);
            input= scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("END")) {
            reservationsSet.remove(input);
            input = scanner.nextLine();
        }

        System.out.println(reservationsSet.size());
        for (String s : reservationsSet) {
            System.out.println(s);
        }

    }
}
