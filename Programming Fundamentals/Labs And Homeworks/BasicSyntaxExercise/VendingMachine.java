package BasicSyntaxExercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = (scanner.nextLine());
        double sum = 0;
        while (!input.equals("Start")) {
            double money = Double.parseDouble(input);
            if (money == 0.1 || money == 0.2 || money == 0.5 || money ==1 || money == 2 ){
                sum += money;
            }else{
                System.out.printf("Cannot accept %.2f%n",money);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("End")){
//"Nuts", "Water", "Crisps", "Soda", "Coke"
           // 2.0, 0.7, 1.5, 0.8, 1.0
           double price=0;
            switch (input){
                case "Nuts":
                    price=2.0;
                    if(sum>=price){
                        sum-=price;
                        System.out.printf("Purchased %s%n",input);
                    }else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    price=0.7;
                    if(sum>=price){
                        sum-=price;
                        System.out.printf("Purchased %s%n",input);
                    }else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    price=1.5;
                    if(sum>=price){
                        sum-=price;
                        System.out.printf("Purchased %s%n",input);
                    }else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    price=0.8;
                    if(sum>=price){
                        sum-=price;
                        System.out.printf("Purchased %s%n",input);
                    }else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    price=1.0;
                    if(sum>=price){
                        sum-=price;
                        System.out.printf("Purchased %s%n",input);
                    }else {
                        System.out.println("Sorry, not enough money");
                    }

                    break;
                default:
                    System.out.println("Invalid product");
            }

            input = scanner.nextLine();

        }
        System.out.printf("Change: %.2f",sum);

    }
}
