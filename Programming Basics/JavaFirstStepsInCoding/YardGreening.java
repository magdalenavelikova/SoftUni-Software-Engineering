package JavaFirstStepsInCoding;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double square=Double.parseDouble(scanner.nextLine());
        double price=(square*7.61);
        double percent=(price*0.18);
        double lastPrice=price-percent;

        System.out.println("The final price is: " + lastPrice+" lv.");
        System.out.println("The discount is: "+ percent+" lv.");
    }
}
