package JavaConditionalStatementsAdvanced;

import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//•	Първи ред – брой дни – цяло число в интервал [1…5000]
//•	Втори ред – оставена храна в килограми – цяло число в интервал [0…100000]
//•	Трети ред – храна на ден за кучето в килограми – реално число в интервал [0.00…100.00]
//•	Четвърти ред – храна на ден за котката в килограми– реално число в интервал [0.00…100.00]
//•	Пети ред – храна на ден за костенурката в грамове – реално число в интервал [0.00…10000.00]
        int day = Integer.parseInt(scanner.nextLine());
        int foodLeft = Integer.parseInt(scanner.nextLine());
        double foodPerDayDog = Double.parseDouble(scanner.nextLine());
        double foodPerDayCat = Double.parseDouble(scanner.nextLine());
        double foodPerDayTurtle = Double.parseDouble(scanner.nextLine()) / 1000;
        double dogFood = day * foodPerDayDog;
        double catFood = day * foodPerDayCat;
        double turtleFood = day * foodPerDayTurtle;
        double food = Math.ceil(dogFood + catFood + turtleFood);
        if (food <= foodLeft) {
            System.out.printf("%.0f kilos of food left.", foodLeft - food);
        }else {
            System.out.printf("%.0f more kilos of food are needed.", food-foodLeft);
        }

    }
}
