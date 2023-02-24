package conditionalStatementsAdvancedLabAndExcercise;

import java.util.Scanner;

public class TankFuel2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fuelType= scanner.nextLine();
        double quantity=Double.parseDouble(scanner.nextLine());
        String clubCard= scanner.nextLine();
        double amountFuel;
        if (fuelType.equals("Diesel")){
            amountFuel=quantity*2.33;
        } else if (fuelType.equals("Gasoline")) {
            amountFuel=quantity*2.22;
        }else {
            amountFuel=quantity*0.93;
        }

        boolean isCardHolder=clubCard.equals("Yes");
        if (isCardHolder){
            if (fuelType.equals("Diesel")){
                amountFuel=amountFuel-quantity*0.12;
            } else if (fuelType.equals("Gasoline")) {
                amountFuel=amountFuel-quantity*0.18;
            }else {
                amountFuel=amountFuel-quantity*0.08;
            }
        }

        if(quantity>=20&&quantity<=25){
            amountFuel=amountFuel-amountFuel*0.08;
    }else if(quantity>25){
            amountFuel=amountFuel-amountFuel*0.10;

        }
        System.out.printf("%.2f lv.",amountFuel);
    }
}
