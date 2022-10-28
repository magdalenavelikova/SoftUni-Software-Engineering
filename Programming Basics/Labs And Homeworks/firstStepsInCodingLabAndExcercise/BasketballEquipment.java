package firstStepsInCodingLabAndExcercise;

import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int taxes=Integer.parseInt(scanner.nextLine());
        double shoes=taxes-(taxes*40/100.);
        double equpment=shoes-(shoes*20/100.);
        double ball=equpment/4.;
        double accessories= ball/5.;

        System.out.println(taxes+shoes+equpment+ball+accessories);

    }

}
