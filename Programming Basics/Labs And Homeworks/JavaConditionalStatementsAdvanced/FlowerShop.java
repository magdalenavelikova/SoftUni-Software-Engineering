package JavaConditionalStatementsAdvanced;

import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        •	Брой магнолии – цяло число в интервала [0 … 50]
//•	Брой зюмбюли – цяло число в интервала [0 … 50]
//•	Брой рози – цяло число в интервала [0 … 50]
//•	Брой кактуси – цяло число в интервала [0 … 50]
//•	Цена на подаръка – реално число в интервала [0.00 … 500.00]
        int magnolias = Integer.parseInt(scanner.nextLine());
        int hyacinths = Integer.parseInt(scanner.nextLine());
        int rose = Integer.parseInt(scanner.nextLine());
        int cactus = Integer.parseInt(scanner.nextLine());
        double giftPrice = Double.parseDouble(scanner.nextLine());
        double magnoliasPrice = magnolias * 3.25;
        double hyacinthsPrice = hyacinths * 4;
        double rosePrice = rose * 3.50;
        double cactusPrice = cactus * 8.0;
        double flowersAmount = magnoliasPrice + hyacinthsPrice + rosePrice + cactusPrice;
        double finalAmount = flowersAmount - (flowersAmount * 0.05);

        if (finalAmount>=giftPrice){
            System.out.printf("She is left with %.0f leva.", Math.floor(finalAmount-giftPrice));
        } else {
            System.out.printf("She will have to borrow %.0f leva.",Math.ceil(giftPrice-finalAmount));
        }


    }
}
