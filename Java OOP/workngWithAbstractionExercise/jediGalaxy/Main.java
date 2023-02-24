package workngWithAbstractionExercise.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Field field = new Field(readCoordinates(input));
        input = scanner.nextLine();
        long points = 0;
        while (!input.equals("Let the Force be with you")) {
            Player player = new Player(readCoordinates(input));
            input = scanner.nextLine();
            Evil evil = new Evil(readCoordinates(input));
            Galaxy galaxy = new Galaxy(field, evil, player);
            galaxy.moveEvil();
            galaxy.movePlayer();
            points += player.getPoints();
            input = scanner.nextLine();
        }
        System.out.println(points);


    }

    private static int[] readCoordinates(String command) {
        return Arrays.stream(command.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }


}
