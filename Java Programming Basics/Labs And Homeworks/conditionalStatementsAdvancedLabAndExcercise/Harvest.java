package conditionalStatementsAdvancedLabAndExcercise;

import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//•1 ви ред: X кв.м е лозето – цяло число в интервала [10 … 5000]
//•	2ри ред: Y грозде за един кв.м – реално число в интервала [0.00 … 10.00]
//•	3ти ред: Z нужни литри вино – цяло число в интервала [10 … 600]
//•	4ти ред: брой работници – цяло число в интервала [1 … 20]
        int x = Integer.parseInt(scanner.nextLine());
        double grapes = Double.parseDouble(scanner.nextLine());
        int littersNeeds = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        double vineyardArea = x * 0.40;
        double harvestGrapes=vineyardArea*grapes;
        double producedWine = harvestGrapes / 2.5;
        if(producedWine<littersNeeds){
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.",Math.floor(littersNeeds-producedWine));
        } else{
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n",Math.floor(producedWine));
            System.out.printf("%.0f liters left -> %.0f liters per person.",Math.ceil(producedWine-littersNeeds),Math.ceil((producedWine-littersNeeds)/workers));
        }


    }
}
