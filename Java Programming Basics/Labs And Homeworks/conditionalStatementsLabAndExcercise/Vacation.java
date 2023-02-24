package conditionalStatementsLabAndExcercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//    ⦁	Първи ред – Бюджет – реално число в интервала [10.00...10000.00]
//⦁	Втори ред –  Сезон – текст "Summer" или "Winter"
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String typeOfPlace="";
        String location="";
        double price=0;
        //"Summer" и "Winter".
        // Локациите са – "Alaska" и "Morocco".
        // Възможните места за настаняване – "Hotel", "Hut" или "Camp".
        if (budget <= 1000) {
            typeOfPlace="Camp";
            if("Summer".equals(season)){
                location="Alaska";
                price=budget*0.65;
            } else {
                location="Morocco";
                price=budget*0.45;
            }

        } else if (budget <= 3000) {
            typeOfPlace="Hut";
            if("Summer".equals(season)){
                location="Alaska";
                price=budget*0.80;
            } else {
                location="Morocco";
                price=budget*0.60;
            }

        }else {
            typeOfPlace="Hotel";
            price=budget*0.9;
            if("Summer".equals(season)){
                location="Alaska";

            } else {
                location="Morocco";

            }

        }
        System.out.printf("%s - %s - %.2f",location,typeOfPlace,price);

    }
}
