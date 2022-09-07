package JavaFirstStepsInCoding;

import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int chikenMenu=Integer.parseInt(scanner.nextLine());
        int fishMenu=Integer.parseInt(scanner.nextLine());
        int veganMenu=Integer.parseInt(scanner.nextLine());

        double amount=(chikenMenu*10.35+fishMenu*12.4+veganMenu*8.15);
        double amountDessert=(amount*20/100.);
        System.out.println(amount+amountDessert+2.50);


    }

}
