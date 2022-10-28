package conditionalStatementsLabAndExcercise;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        ⦁	На първия ред е месецът – May, June, July, August, September или October
//⦁	На втория ред е броят на нощувките – цяло число в интервала [0 ... 200]
        String month = scanner.nextLine();
        int overnight = Integer.parseInt(scanner.nextLine());
        double studioPrice = 0;
        double apartmentPrice = 0;
        switch (month) {
            case "May":
            case "October":
                studioPrice = 50;
                apartmentPrice = 65;
                break;
            case "June":
            case "September":
                studioPrice = 75.20;
                apartmentPrice = 68.7;
                break;
            case "July":
            case "August":
                studioPrice = 76;
                apartmentPrice = 77;
                break;
        }


        if ("May".equals(month) || "October".equals(month)) {
            if (overnight > 7 && overnight<=14) {
                studioPrice = studioPrice - (studioPrice * 0.05);

            } else if (overnight > 14) {
                studioPrice = studioPrice - (studioPrice * 0.30);

            }
        } else if ("June".equals(month) || "September".equals(month)) {
            if (overnight > 14) {
                studioPrice = studioPrice - (studioPrice * 0.20);
            }
        }

        if (overnight > 14) {
            apartmentPrice = apartmentPrice - (apartmentPrice * 0.1);
        }
        double amountStudio = studioPrice * overnight;
        double amountApartment = apartmentPrice * overnight;
        System.out.printf("Apartment: %.2f lv.%n", amountApartment);
        System.out.printf("Studio: %.2f lv.%n", amountStudio);

    }
}
