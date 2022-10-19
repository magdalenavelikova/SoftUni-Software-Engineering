package dataTypesAndVariables;

import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int meters=Integer.parseInt(scanner.nextLine());
        double km=meters/(1000*1.0);
        System.out.printf("%.2f",km);
    }
}
