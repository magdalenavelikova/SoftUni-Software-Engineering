package PBJavaForLoopLab;

import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        ⦁	Възрастта на Лили - цяло число в интервала [1...77]
//⦁	Цената на пералнята - число в интервала [1.00...10 000.00]
//⦁	Единична цена на играчка - цяло число в интервала [0...40]
        int age = Integer.parseInt(scanner.nextLine());
        double priceWashingMachine = Double.parseDouble(scanner.nextLine());
        double pricePerToy = Double.parseDouble(scanner.nextLine());
        double savings = 0;
        int toys = 0;

        for (int i = 1; i <= age; i++) {
            boolean isEven = i % 2 == 0;
            if (isEven) {
                savings += (((i / 2.0) * 10.0) - 1.0);
            } else {
                toys += 1;
            }
        }
        savings = savings + (toys * pricePerToy);
        double diff=savings-priceWashingMachine;
        if (diff>=0){
            System.out.printf("Yes! %.2f",diff);
        } else {
            System.out.printf("No! %.2f",priceWashingMachine-savings);
        }

    }
}
