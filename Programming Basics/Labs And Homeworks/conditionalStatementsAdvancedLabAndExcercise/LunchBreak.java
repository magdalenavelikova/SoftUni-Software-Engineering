package conditionalStatementsAdvancedLabAndExcercise;

import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameSerials = scanner.nextLine();
        int durationSeries = Integer.parseInt(scanner.nextLine());
        int durationTimeOut = Integer.parseInt(scanner.nextLine());
        double timeForLunch=0.125*durationTimeOut;
        double timeForRest=0.25*durationTimeOut;
        double durationLeft=durationTimeOut-(timeForLunch+timeForRest);
        if (durationLeft>=durationSeries){
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.",nameSerials,Math.ceil(durationLeft-durationSeries));
        }else{
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.",nameSerials,Math.ceil(durationSeries-durationLeft));
        }
             }
}
