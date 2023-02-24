package objectsAndClassesLab;

import java.time.LocalDate;
import java.util.Scanner;

public class Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = Integer.parseInt(scanner.nextLine());
        int month = Integer.parseInt(scanner.nextLine());
        int day = Integer.parseInt(scanner.nextLine());

        LocalDate birthday = LocalDate.of(year, month, day);
        birthday=birthday.plusYears(30);//метод който връща данни, затова трябва да го присвоя на променлива
        System.out.println(birthday);
    }
}
