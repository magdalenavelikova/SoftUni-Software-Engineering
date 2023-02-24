package forLoopLabAndExcercise;

import java.util.Scanner;

public class TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //⦁	Брой турнири, в които е участвал – цяло число в интервала [1…20]
        //⦁	Начален брой точки в ранглистата - цяло число в интервала [1...4000]
        int tournament = Integer.parseInt(scanner.nextLine());
        int startPoints = Integer.parseInt(scanner.nextLine());
        int points = startPoints;
        int countWin = 0;
        for (int i = 0; i < tournament; i++) {
            String position = scanner.nextLine();
            switch (position) {
                case "W":
                    points += 2000;
                    countWin += 1;
                    break;
                case "F":
                    points += 1200;
                    break;
                case "SF":
                    points += 720;
            }

        }
        double averagePoints = (points - startPoints)*1.0 / tournament;
        double percentWin = (countWin / (tournament * 1.0)) * 100;
        System.out.printf("Final points: %d%n",points);
        System.out.printf("Average points: %.0f%n",Math.floor(averagePoints));
        System.out.printf("%.2f",percentWin);
        System.out.println("%");


    }
}
