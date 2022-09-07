package JavaConditionalStatementsAdvanced;

import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int points = Integer.parseInt(scanner.nextLine());
        double bonus = 0;
        int extraBonus = 0;
        boolean isPositive = points % 2 == 0;
        boolean isFive = points % 10 == 5;

        if (isFive) {
            extraBonus = 2;
        }
        if (isPositive) {
            extraBonus = 1 + extraBonus;
        }
        if (points <= 100) {
            bonus = 5.;
        } else if (points <= 1000) {
            bonus = points * 0.2;
        } else {
            bonus = points * 0.1;
        }
        double pointSum = points + bonus + extraBonus;
        double bonusSum =  bonus + extraBonus;
        System.out.printf("%.1f", bonusSum);
        System.out.println();
        System.out.printf("%.1f", pointSum);

    }
}
