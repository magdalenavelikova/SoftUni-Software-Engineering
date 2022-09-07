package ExamineЕxercise2;

import java.util.Scanner;

public class Balls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        От конзолата се чете 1 цяло число N, което е броят на топките в диапазон (0-1000).
//2. След това се четат N на брой цветове.
        int n = Integer.parseInt(scanner.nextLine());

        double totalPoints = 0;
        int countBlack = 0;
        int countRed = 0;
        int countOrange = 0;
        int countYellow = 0;
        int countWhite = 0;
        int countOthes = 0;
        double points = 0;

        for (int i = 0; i < n; i++) {
            boolean isOthers = true;
            String colour = scanner.nextLine();
            switch (colour) {
                case "red":
                    isOthers = false;
                    countRed++;
                    points += 5;
                    break;
                case "orange":
                    isOthers = false;
                    countOrange++;
                    points += 10;
                    break;
                case "yellow":
                    isOthers = false;
                    countYellow++;
                    points += 15;
                    break;
                case "white":
                    isOthers = false;
                    countWhite++;
                    points += 20;
                    break;
                case "black":
                    isOthers = false;
                    countBlack++;
                    points = Math.floor(points / 2);
                    break;
            }
            // totalPoints += points;
            if (isOthers) {
                countOthes++;
            }
        }
        System.out.printf("Total points: %.0f%n", points);
        System.out.printf("Red balls: %d%n", countRed);
        System.out.printf("Orange balls: %d%n", countOrange);
        System.out.printf("Yellow balls: %d%n", countYellow);
        System.out.printf("White balls: %d%n", countWhite);
        System.out.printf("Other colors picked: %d%n", countOthes);
        System.out.printf("Divides from black balls: %d%n", countBlack);
//        Total points: {всичките събрани точки}"
//"Red balls: {броят червени топки}"
//"Orange balls: {броят оранжеви топки}"
//"Yellow balls: {броят жълти топки}"
//"White balls: {броят бели топки}"
//"Other colors picked: {броят на избраните топки извън зададените цветове}"
//"Divides from black balls: {броят на пътите, в които точките са били разделяни на 2}"
    }
}
