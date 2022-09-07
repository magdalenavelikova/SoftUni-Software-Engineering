package JavaFirstStepsInCoding;

import java.util.Scanner;

public class VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int pages=Integer.parseInt(scanner.nextLine());
        int pagesPerHour=Integer.parseInt(scanner.nextLine());
        int days=Integer.parseInt(scanner.nextLine());

        int hoursPerDay=(pages/pagesPerHour)/days;
        System.out.println(hoursPerDay);

    }
}
