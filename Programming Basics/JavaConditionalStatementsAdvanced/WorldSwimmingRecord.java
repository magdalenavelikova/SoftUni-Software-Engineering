package JavaConditionalStatementsAdvanced;

import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        1.	Рекордът в секунди – реално число в интервала [0.00 … 100000.00]
//        2.	Разстоянието в метри – реално число в интервала [0.00 … 100000.00]
//        3.	Времето в секунди, за което плува разстояние от 1 м. - реално число в интервала [0.00 … 1000.00]

        double recordSec=Double.parseDouble(scanner.nextLine());
        double distance=Double.parseDouble(scanner.nextLine());
        double timePerSeconds=Double.parseDouble(scanner.nextLine());
        double resistance=Math.floor(distance/15);
        double resistanceDelay=resistance*12.5;
        double time=distance*timePerSeconds+resistanceDelay;
        if (time<recordSec){
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", time);
        }else{
            System.out.printf("No, he failed! He was %.2f seconds slower.",time-recordSec);
        }


    }
}
