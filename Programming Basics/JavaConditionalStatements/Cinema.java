package JavaConditionalStatements;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type= scanner.nextLine();
        int rows=Integer.parseInt(scanner.nextLine());
        int column=Integer.parseInt(scanner.nextLine());
        double price=0;
        switch (type){
            case"Premiere":
                price=12.;
                break;
            case "Normal":
                price=7.5;
                break;
            case "Discount":
                price=5;
                break;
        }
        System.out.printf("%.2f leva",rows*column*price);
    }
}
