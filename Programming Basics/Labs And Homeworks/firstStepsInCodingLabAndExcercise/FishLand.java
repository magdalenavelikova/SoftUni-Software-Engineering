package firstStepsInCodingLabAndExcercise;

import java.util.Scanner;

public class FishLand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceMackerel = Double.parseDouble(scanner.nextLine());
        double priceSprinkle = Double.parseDouble(scanner.nextLine());
        double kgBonito = Double.parseDouble(scanner.nextLine());
        double kgSafrid = Double.parseDouble(scanner.nextLine());
        int kgMussels=Integer.parseInt(scanner.nextLine());
        double amountBonito=kgBonito*(priceMackerel+priceMackerel*0.6);
        double amountSafrid=kgSafrid*(priceSprinkle+priceSprinkle*0.8);
        double amountMussel=kgMussels*7.50;

        System.out.printf("%.2f", (amountBonito+amountMussel+amountSafrid));

    }

}
