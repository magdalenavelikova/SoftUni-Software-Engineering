package ExamineExercise1;

import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bitcoins = Integer.parseInt(scanner.nextLine());
        double chineseYuan = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());
        double amountLevs= (bitcoins*1168)+((chineseYuan*0.15)*1.76);
        double amountEuro= amountLevs/1.95;
        double amountEuroWithoutCommission=amountEuro-(amountEuro*(commission/100));

        System.out.println(amountEuroWithoutCommission);
    }
}
