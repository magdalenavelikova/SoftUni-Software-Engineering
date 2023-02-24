package conditionalStatementsLabAndExcercise;

import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//⦁	Първи ред – Бюджет – реално число в интервала [10.00...10000.00]
//⦁	Втори ред –  Сезон – текст "Summer" или "Winter"
        double budjet = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String classOfCar = "";
        double price = 0;

        String typeOfCar = "";
        if (budjet <= 100) {
            classOfCar = "Economy class";
            if ("Summer".equals(season)) {
                typeOfCar = "Cabrio";
                price = budjet * 0.35;
            } else {
                typeOfCar = "Jeep";
                price = budjet * 0.65;
            }

        } else if (budjet <= 500) {
            classOfCar = "Compact class";
            if ("Summer".equals(season)) {
                typeOfCar = "Cabrio";
                price = budjet * 0.45;
            } else {
                typeOfCar = "Jeep";
                price = budjet * 0.80;
            }
        } else {
            classOfCar = "Luxury class";
            typeOfCar = "Jeep";
            price = budjet * 0.90;
        }
        System.out.println(classOfCar);
        System.out.printf("%s - %.2f",typeOfCar,price);


    }
}
