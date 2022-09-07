package JavaFirstStepsInCoding;

import java.util.Scanner;

public class FishTank {
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int lenght=Integer.parseInt(scanner.nextLine());
            int wight=Integer.parseInt(scanner.nextLine());
            int hight=Integer.parseInt(scanner.nextLine());
            double percent=Double.parseDouble(scanner.nextLine());

            double litre=(lenght*hight*wight)*0.001;
            double capacity=litre*(1-percent/100.);
            System.out.println(capacity);

    }
}
