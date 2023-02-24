package midExam23102022;

import java.util.Scanner;

public class BiscuitFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfBiscuitsPerDay = Integer.parseInt(scanner.nextLine());
        int countOfWorkers = Integer.parseInt(scanner.nextLine());
        long quantityOfBiscuitsSecondFactoryPerMonth = Long.parseLong(scanner.nextLine());
        double quantityOfBiscuitsPerDay = 0;
        long quantityOfBiscuitsFirstFactoryPerMonth = 0;
        for (int days = 1; days <= 30; days++) {
            quantityOfBiscuitsPerDay = numberOfBiscuitsPerDay * countOfWorkers;
            if (days % 3 == 0) {
                quantityOfBiscuitsPerDay = Math.floor(quantityOfBiscuitsPerDay * 0.75);

            }
            quantityOfBiscuitsFirstFactoryPerMonth += quantityOfBiscuitsPerDay;

        }
        System.out.printf("You have produced %d biscuits for the past month.%n", quantityOfBiscuitsFirstFactoryPerMonth);
        double difference=(quantityOfBiscuitsFirstFactoryPerMonth - quantityOfBiscuitsSecondFactoryPerMonth)*1.0;
        double  percentage = (difference / quantityOfBiscuitsSecondFactoryPerMonth) * 100;


        if (quantityOfBiscuitsFirstFactoryPerMonth > quantityOfBiscuitsSecondFactoryPerMonth) {

            System.out.printf("You produce %.2f percent more biscuits.%n", Math.abs(percentage));
        } else {
            System.out.printf("You produce %.2f percent less biscuits.%n",Math.abs(percentage));
        }

    }
}
