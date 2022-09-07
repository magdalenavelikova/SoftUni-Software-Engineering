package JavaConditionalStatementsAdvanced;

import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        •	Първият ред съдържа числото n – брой километри – цяло число в интервала [1…5000]
//•	Вторият ред съдържа дума “day” или “night” – пътуване през деня или през нощта
        int km = Integer.parseInt(scanner.nextLine());
        String partOfDay = scanner.nextLine();
        double taxiPrice = 0.;
        double busPrice = 0.;
        double trainPrice = 0.;
        if (partOfDay.equals("day")) {
            taxiPrice = km * 0.79 + 0.7;
        } else {
            taxiPrice = km * 0.90 + 0.7;
        }
        if (km >= 20) {
            busPrice = km * 0.09;
        }
        if (km >= 100) {
            trainPrice = km * 0.06;
        }

        double lowerPrice = 0.;
        if (km < 20) {
            lowerPrice = taxiPrice;
        } else if (km < 100) {
            if (busPrice < taxiPrice) {
                lowerPrice = busPrice;
            } else {
                lowerPrice = taxiPrice;
            }
        } else {
           // double lowerPrice1 = Math.min(taxiPrice, trainPrice);
            if (busPrice < taxiPrice && busPrice < trainPrice) {
                lowerPrice = busPrice;
            } else if (trainPrice < taxiPrice) {
                lowerPrice = trainPrice;
            } else
                lowerPrice = taxiPrice;
        }
        //System.out.printf("%.2f",lowerPrice);

    }


}
