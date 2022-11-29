package exam;

import java.util.Scanner;

public class SinoTheWalker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String time = scanner.nextLine();
        int numberOfSteps = Integer.parseInt(scanner.nextLine()) % 86400;
        int timePerStep = Integer.parseInt(scanner.nextLine()) % 86400;
        int timeAmount = numberOfSteps * timePerStep;
        int hours = 0;


        int minutes = timeAmount / 60;
        int seconds = timeAmount % 60;

        if (minutes >= 60) {
            hours = minutes / 60;
            minutes = minutes % 60;
        }
        int startHours = Integer.parseInt(time.split(":")[0]);
        int startMinutes = Integer.parseInt(time.split(":")[1]);
        int startSeconds = Integer.parseInt(time.split(":")[2]);
        int arrivalHours = startHours + hours;
        int arrivalMinutes = startMinutes + minutes;
        int arrivalSeconds = startSeconds + seconds;
        if (arrivalSeconds >= 60) {
            arrivalMinutes += arrivalSeconds / 60;
            arrivalSeconds = arrivalSeconds % 60;

        }
        if (arrivalMinutes >= 60) {
            arrivalHours += arrivalMinutes / 60;
            arrivalMinutes = arrivalMinutes % 60;
        }
        if (arrivalHours >= 24) {
            arrivalHours = arrivalHours % 24;
        }
        System.out.printf("Time Arrival: %02d:%02d:%02d%n", arrivalHours, arrivalMinutes, arrivalSeconds);

    }
}
