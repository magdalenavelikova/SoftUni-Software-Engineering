package JavaFirstStepsInCoding;

import java.util.Scanner;

public class Repainting {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int nylon=Integer.parseInt(scanner.nextLine());
        int paint=Integer.parseInt(scanner.nextLine());
        int thinner=Integer.parseInt(scanner.nextLine());
        int hour=Integer.parseInt(scanner.nextLine());

        double amount=((nylon+2)*1.5)+((paint+(paint*10/100.))*14.5)+(thinner*5.)+.4;

        double salaryPerHour=(amount*30/100);
        double salary=hour*salaryPerHour;
        System.out.println(amount+salary);



    }

}
