package JavaConditionalStatementsAdvanced;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Цена на екскурзията - реално число в интервала [1.00 … 10000.00]
//         Брой пъзели - цяло число в интервала [0… 1000]
//         Брой говорещи кукли - цяло число в интервала [0 … 1000]
//         Брой плюшени мечета - цяло число в интервала [0 … 1000]
//         Брой миньони - цяло число в интервала [0 … 1000]
//         Брой камиончета - цяло число в интервала [0 … 1000]
        double tripPrice = Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int teddyBear = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());
        int allToys = puzzles + dolls + teddyBear + minions + trucks;
      //  double totalProfit = puzzles * 2.6 + dolls * 3. + teddyBear * 4.1 + minions * 8.2 + trucks * 2;
        double pricePuzzels=puzzles*2.60;
        double priceDolls=dolls*3;
        double priceTeddyBear=teddyBear*4.10;
        double priceMinions=minions*8.20;
        double priceTrucks=trucks*2.00;
        double totalProfit=priceMinions+priceDolls+priceTrucks+pricePuzzels+priceTeddyBear;
        if (allToys >= 50) {
            totalProfit = totalProfit - (totalProfit * 0.25);
        }
        totalProfit = totalProfit - (totalProfit * 0.10);

        if (totalProfit >= tripPrice) {
            System.out.printf("Yes! %.2f lv left.", totalProfit - tripPrice);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", tripPrice - totalProfit);
        }


    }
}
