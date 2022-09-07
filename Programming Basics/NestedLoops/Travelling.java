package NestedLoops;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input= scanner.nextLine();
       // double budget=Double.parseDouble(scanner.nextLine());
//        boolean isSaved=false;
        while (!input.equals("End")){
            String destination=input;
            double savedMoney=0;

            double budget=Double.parseDouble(scanner.nextLine());
            while (savedMoney<budget){
                double money=Double.parseDouble(scanner.nextLine());
                savedMoney+=money;
//                if (savedMoney==budget){
//                    isSaved=true;
//                }
            }
            if (savedMoney>=budget) {
                System.out.printf("Going to %s!%n",input);
            }
            input= scanner.nextLine();



        }
    }
}
