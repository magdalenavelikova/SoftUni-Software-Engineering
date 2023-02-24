package conditionalStatementsAdvancedLabAndExcercise;

import java.util.Scanner;

public class SleepyTom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int holidays = Integer.parseInt(scanner.nextLine());
        int workDays = 365 - holidays;
        int playTime = holidays * 127 + workDays * 63;
        int rest;
        if (playTime<=30000){
            rest=30000-playTime;
        }else{
            rest=playTime-30000;
        }
        int hours = rest / 60;
        int minutes = rest % 60;

        if (playTime<=30000){
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play",hours, minutes);

        }else {
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play",hours, minutes);
        }
    }
}
