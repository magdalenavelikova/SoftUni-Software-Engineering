package genericsExercise.tuple;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        String name = input[0] + " " + input[1];
        String city = input[2];
        Tuple<String, String> firstTuple = new Tuple<>(name, city);

        input = scanner.nextLine().split("\\s+");
        name = input[0];
        int litersOfBeer = Integer.parseInt(input[1]);
        Tuple<String, Integer> secondTuple = new Tuple<>(name, litersOfBeer);

        input = scanner.nextLine().split("\\s+");
        int intElement = Integer.parseInt(input[0]);
        double doubleElement = Double.parseDouble(input[1]);
        Tuple<Integer, Double> thirdTuple = new Tuple<>(intElement, doubleElement);
        System.out.println(firstTuple);
        System.out.println(secondTuple);
        System.out.println(thirdTuple);

    }

}
