package JavaConditionalStatementsAdvanced;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double filmBudget = Double.parseDouble(scanner.nextLine());
        int statist = Integer.parseInt(scanner.nextLine());
        double priceClothes = Double.parseDouble(scanner.nextLine());
        double decor = filmBudget * 0.10;
        double clothesBudget = statist * priceClothes;

        if (statist > 150) {
            clothesBudget = clothesBudget - (clothesBudget * 0.10);
        }
        double expenses = decor + clothesBudget;
        if (expenses > filmBudget) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", expenses - filmBudget);

        } else{
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", filmBudget - expenses);
    }
}
}
