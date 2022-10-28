package whileLabAndExercise;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int lenght = Integer.parseInt(scanner.nextLine());
        int hight = Integer.parseInt(scanner.nextLine());
        int room = width * lenght * hight;
        int boxes = 0;
        boolean isRoomFull = false;
        String command = scanner.nextLine();
        while (!command.equals("Done")) {
            int box = Integer.parseInt(command);
            boxes += box * (1 * 1 * 1);


            if (boxes >= room) {
                isRoomFull = true;
                break;
            }
            command = scanner.nextLine();
        }
        if (isRoomFull) {
            System.out.printf("No more free space! You need %d Cubic meters more.", boxes - room);

        } else {
            System.out.printf("%d Cubic meters left.", room - boxes);
        }
    }
}
