package genericsExercise.threeuple;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        String name = input[0] + " " + input[1];
        String address = input[2];
        String city = input[3];
        Threeuple<String, String, String> firstThreeuple = new Threeuple<>(name, address, city);

        input = scanner.nextLine().split("\\s+");
        name = input[0];
        int litersOfBeer = Integer.parseInt(input[1]);
        boolean isDrunk=input[2].equals("drunk");
        Threeuple<String, Integer,Boolean> secondThreeuple = new Threeuple<>(name, litersOfBeer,isDrunk);

        input = scanner.nextLine().split("\\s+");
        name = input[0];
        double accountBalance = Double.parseDouble(input[1]);
        String nameOfBank = input[2];
        Threeuple<String, Double,String> thirdThreeuple = new Threeuple<>(name,accountBalance,nameOfBank);
        System.out.println(firstThreeuple);
        System.out.println(secondThreeuple);
        System.out.println(thirdThreeuple);

    }

}
