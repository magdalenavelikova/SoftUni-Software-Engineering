package midExam23102022;

import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] vehicles = scanner.nextLine().split(">>");
        double totalTaxToPay = 0;

        for (int i = 0; i < vehicles.length; i++) {
            int counterForKm = 0;
            double initialTax = 0;
            double totalTaxPerVehicle = 0;
            String carType = vehicles[i].split("\\s+")[0];
            int yearsPerTax = Integer.parseInt(vehicles[i].split("\\s+")[1]);
            int kilometers = Integer.parseInt(vehicles[i].split("\\s+")[2]);
            switch (carType) {
                case "family":
                    initialTax = 50;
                    initialTax = initialTax - (yearsPerTax * 5);
                    counterForKm = kilometers / 3000;
                    totalTaxPerVehicle = (counterForKm * 12) + initialTax;
                    System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, totalTaxPerVehicle);
                    totalTaxToPay += totalTaxPerVehicle;
                    break;
                case "heavyDuty":
                    initialTax = 80;
                    initialTax = initialTax - (yearsPerTax * 8);
                    counterForKm = kilometers / 9000;
                    totalTaxPerVehicle = (counterForKm * 14) + initialTax;
                    System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, totalTaxPerVehicle);
                    totalTaxToPay += totalTaxPerVehicle;
                    break;
                case "sports":
                    initialTax = 100;
                    initialTax = initialTax - (yearsPerTax * 9);
                    counterForKm = kilometers / 2000;
                    totalTaxPerVehicle = (counterForKm * 18) + initialTax;
                    System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, totalTaxPerVehicle);
                    totalTaxToPay += totalTaxPerVehicle;
                    break;
                default:
                    System.out.println("Invalid car type.");
                    break;
            }
        }
        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.", totalTaxToPay);
    }
}
