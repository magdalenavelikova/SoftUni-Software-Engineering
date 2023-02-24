package forLoopLabAndExcercise;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Първи ред – месеците за които се търси средният разход – цяло число в интервала [1...100]
        int months = Integer.parseInt(scanner.nextLine());
        double waterBill = 20;
        double internetBill = 15;
        double othersBill = 0;
        double allAmount = 0;
        double electricityAmount = 0;
        double waterAmount = 0;
        double internetAmount = 0;
        double othersAmount = 0;
        //за други – събират се тока, водата и интернета за месеца и към сумата се прибавят 20%.
        for (int i = 0; i < months; i++) {
            double electricityBill = Double.parseDouble(scanner.nextLine());
            waterAmount += waterBill;
            internetAmount += internetBill;
            electricityAmount += electricityBill;
            othersBill = (electricityBill + waterBill + internetBill) * 1.2;
            othersAmount += othersBill;
            allAmount += electricityBill + internetBill + waterBill + othersBill;

        }
        System.out.printf("Electricity: %.2f lv%n", electricityAmount);
        System.out.printf("Water: %.2f lv%n", waterAmount);
        System.out.printf("Internet: %.2f lv%n", internetAmount);
        System.out.printf("Other: %.2f lv%n", othersAmount);
        System.out.printf("Average: %.2f lv%n", allAmount / months);

    }
}
