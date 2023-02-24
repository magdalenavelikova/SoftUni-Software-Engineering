package conditionalStatementsLabAndExcercise;

import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String town= scanner.nextLine();
        double sales=Double.parseDouble(scanner.nextLine());
        double commission=0.0;
       // int roundSales=Math.ceil(sales);
        if (sales>=0 && sales<=500){
            switch (town){
                case "Sofia":
                    commission=0.05;
                    break;
                case "Varna":
                    commission=0.045;
                    break;
                case "Plovdiv":
                    commission=0.055;
                    break;
            }
        } else if (sales>500 && sales<=1000) {
            switch (town){
                case "Sofia":
                    commission=0.07;
                    break;
                case "Varna":
                    commission=0.075;
                    break;
                case "Plovdiv":
                    commission=0.08;
                    break;
            }
        } else if (sales>1000 && sales<=10000) {
            switch (town){
                case "Sofia":
                    commission=0.08;
                    break;
                case "Varna":
                    commission=0.10;
                    break;
                case "Plovdiv":
                    commission=0.12;
                    break;
            }
        }else if (sales>10000) {
            switch (town){
                case "Sofia":
                    commission=0.12;
                    break;
                case "Varna":
                    commission=0.13;
                    break;
                case "Plovdiv":
                    commission=0.145;
                    break;
            }
        }


        if (commission>0){
            System.out.printf("%.2f",sales*commission);
        } else {
            System.out.println("error");
        }
    }
}
