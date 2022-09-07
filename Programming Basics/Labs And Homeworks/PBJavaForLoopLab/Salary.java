package PBJavaForLoopLab;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //⦁	Брой отворени табове в браузъра n - цяло число в интервала [1...10]
        //⦁	Заплата - число в интервала [500...1500]
        int tabsCount = Integer.parseInt(scanner.nextLine());
        double salary = Double.parseDouble(scanner.nextLine());
        double penalty = 0;
        double diff = 0;
        for (int i = 0; i < tabsCount; i++) {
            String website = scanner.nextLine();
            switch (website) {
                case "Facebook":
                    penalty += 150.0;
                    break;
                case "Instagram":
                    penalty += 100.0;
                    break;
                case "Reddit":
                    penalty += 50.;
                    break;
            }
            diff = salary - penalty;
            if (diff <= 0) {
                i = tabsCount;
                System.out.println("You have lost your salary.");
            }
        }
        if (diff > 0) {
            System.out.printf("%.0f", Math.ceil(diff));
        }


    }
}
