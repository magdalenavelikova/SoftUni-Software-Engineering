package dataTypesAndVariablesExercise;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//You will be given the poke power the Poke Mon has, N – an integer.
//Then you will be given the distance between the poke targets, M – an integer.
//Then you will be given the exhaustionFactor Y – an integer.
        int pokePower = Integer.parseInt(scanner.nextLine());
        int startPokePower = pokePower;
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int countPoke = 0;
        while (distance <= pokePower) {
            pokePower -= distance;
            countPoke++;
            if ((startPokePower / 2 == pokePower) && exhaustionFactor > 0) {

                pokePower = pokePower / exhaustionFactor;
            }
        }
        System.out.println(pokePower);
        System.out.println(countPoke);
    }
}
