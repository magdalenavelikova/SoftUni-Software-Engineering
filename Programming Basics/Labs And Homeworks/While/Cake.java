package While;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int lenght = Integer.parseInt(scanner.nextLine());
        int cakeInCm = width * lenght;
        int piecesInCm = 0;
        boolean isCakeFinish=false;
        String command = scanner.nextLine();
        while (!command.equals("STOP")) {
            int pieces = Integer.parseInt(command);
            piecesInCm += pieces * (1 * 1);


            if(piecesInCm>=cakeInCm){
                isCakeFinish=true;
                break;
            }
            command = scanner.nextLine();
        }
if(isCakeFinish){
    System.out.printf("No more cake left! You need %d pieces more.",piecesInCm-cakeInCm);

}else {
    System.out.printf("%d pieces are left.",cakeInCm-piecesInCm);
}

    }
}
