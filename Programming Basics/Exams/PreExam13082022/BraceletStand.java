package preExam13082022;

import java.util.Scanner;

public class BraceletStand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pocketMoney=Double.parseDouble(scanner.nextLine());
        double salesMoney=Double.parseDouble(scanner.nextLine());
        double costs=Double.parseDouble(scanner.nextLine());
        double presentPrice=Double.parseDouble(scanner.nextLine());
        double savedMoney=(pocketMoney+salesMoney)*5;
        double moneyForPresent=savedMoney-costs;
        if(moneyForPresent>=presentPrice){
            System.out.printf("Profit: %.2f BGN, the gift has been purchased.",moneyForPresent);
        }else{
            System.out.printf("Insufficient money: %.2f BGN.",presentPrice-moneyForPresent);
        }


    }
}
