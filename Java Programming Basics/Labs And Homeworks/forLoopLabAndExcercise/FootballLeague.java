package forLoopLabAndExcercise;

import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        int quantityFans = Integer.parseInt(scanner.nextLine());
        int countFansInA = 0;
        int countFansInB = 0;
        int countFansInV = 0;
        int countFansInG = 0;
        for (int i = 0; i < quantityFans; i++) {
            String sector = scanner.nextLine();
            switch (sector) {
                case "A":
                    countFansInA += 1;
                    break;
                case "B":
                    countFansInB += 1;
                    break;
                case "V":
                    countFansInV += 1;
                    break;
                case "G":
                    countFansInG += 1;
                    break;
            }

        }

        System.out.printf("%.2f", (countFansInA / (quantityFans * 1.0)) * 100);
        System.out.println("%");
//        Процентът на феновете в сектор А
        System.out.printf("%.2f", (countFansInB / (quantityFans * 1.0)) * 100);
        System.out.println("%");
//Процентът на феновете в сектор Б
        System.out.printf("%.2f", (countFansInV / (quantityFans * 1.0)) * 100);
        System.out.println("%");
//Процентът на феновете в сектор В
        System.out.printf("%.2f", (countFansInG / (quantityFans * 1.0)) * 100);
        System.out.println("%");
//Процентът на феновете в сектор Г
        System.out.printf("%.2f", (quantityFans / (capacity * 1.0)) * 100);
        System.out.println("%");
//Процентът на всички фенове, спрямо капацитета на стадиона.

    }
}
