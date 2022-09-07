package JavaFirstStepsInCoding;

import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double deposit = Double.parseDouble(scanner.nextLine());
        int month=Integer.parseInt(scanner.nextLine());
        double percent= Double.parseDouble(scanner.nextLine());

        double sum= deposit+(month*(deposit*(percent/100))/12);
        System.out.println(sum);
    }
}
