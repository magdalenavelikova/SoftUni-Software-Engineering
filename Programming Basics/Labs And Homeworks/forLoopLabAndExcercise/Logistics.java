package forLoopLabAndExcercise;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cargos = Integer.parseInt(scanner.nextLine());
        double priceBus = 0;
        double priceTruck = 0;
        double priceTrain = 0;
        int tonAllCargo = 0;
        int tonCargoBus = 0;
        int tonCargoTruck = 0;
        int tonCargoTrain = 0;
        for (int i = 0; i < cargos; i++) {
            int ton = Integer.parseInt(scanner.nextLine());
            tonAllCargo += ton;
            if (ton <= 3) {
                tonCargoBus += ton;
                priceBus += 200.0 * ton;
            } else if (ton <= 11) {
                priceTruck += 175.0 * ton;
                tonCargoTruck += ton;
            } else {
                priceTrain += 120.0 * ton;
                tonCargoTrain += ton;
            }
        }
        double amount = priceBus + priceTrain + priceTruck;
        double averagePrice = amount / tonAllCargo;
        double percentBus =(tonCargoBus/(tonAllCargo*1.0))*100;
        double percentTruck =(tonCargoTruck/(tonAllCargo*1.0))*100;
        double percentTrain =(tonCargoTrain/(tonAllCargo*1.0))*100;
        System.out.printf("%.2f%n",averagePrice);
        System.out.printf("%.2f",percentBus);
        System.out.println("%");
        System.out.printf("%.2f",percentTruck);
        System.out.println("%");
        System.out.printf("%.2f",percentTrain);
        System.out.println("%");
    }
}
