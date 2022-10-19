package midExam;

import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double quantityFood = Double.parseDouble(scanner.nextLine()) * 1000;
        double quantityHay = Double.parseDouble(scanner.nextLine()) * 1000;
        double quantityCover = Double.parseDouble(scanner.nextLine()) * 1000;
        double weight = Double.parseDouble(scanner.nextLine()) * 1000;
        int days = 1;
        boolean isFinished = false;

        while (days <= 30 ) {
            if (quantityFood <= 300 ) {
                isFinished = true;
                break;
            } else {
                quantityFood -= 300;
            }

            if (days % 2 == 0) {
                if (quantityHay <= quantityFood * 0.05 ) {
                    isFinished = true;
                    break;
                } else {
                    quantityHay -= quantityFood * 0.05;
                }
            }

            if (days % 3 == 0) {
                if (quantityCover <= weight / 3 ) {
                    isFinished = true;
                    break;
                } else {
                    quantityCover -= (weight / 3);
                }
            }
            days++;
        }
        quantityFood /= 1000;
        quantityHay /= 1000;
        quantityCover /= 1000;
        if (isFinished) {
            System.out.println("Merry must go to the pet store!");
        } else {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", quantityFood, quantityHay, quantityCover);
        }
    }
}
