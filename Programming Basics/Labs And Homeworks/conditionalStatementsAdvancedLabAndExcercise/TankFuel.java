package conditionalStatementsAdvancedLabAndExcercise;

import java.util.Locale;
import java.util.Scanner;

public class TankFuel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fuelType= scanner.nextLine();

        double tankContent=Double.parseDouble(scanner.nextLine());
        if (fuelType.equals("Diesel")||fuelType.equals("Gasoline")||fuelType.equals("Gas")){
            if(tankContent>=25){
                System.out.printf("You have enough %s.",(fuelType.toLowerCase(Locale.ROOT)));

            }else {
                System.out.printf("Fill your tank with %s!",fuelType.toLowerCase());
            }
        }else {
            System.out.println("Invalid fuel!");
        }

    }
}
