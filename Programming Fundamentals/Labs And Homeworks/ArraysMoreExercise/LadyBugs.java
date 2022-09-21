package ArraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int[] indexArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[] ladyBugsArr = new String[length];

        for (int i = 0; i < ladyBugsArr.length; i++) {
            ladyBugsArr[i] = "0";
        }
        for (int i = 0; i < indexArr.length; i++) {
            if (indexArr[i] >= 0 && indexArr[i] <= length - 1) {
                ladyBugsArr[indexArr[i]] = "1";
            }
        }
        String inputLine = scanner.nextLine();
        while (!inputLine.equals("end")) {
            int ladybugIndex = 0;
            int flyLength = 0;
            String[] flyArray = inputLine.split(" ");
            ladybugIndex = Integer.parseInt(flyArray[0]);
            flyLength = Integer.parseInt(flyArray[2]);
            String temp = "";
            if ((ladybugIndex >= 0 && ladybugIndex <= length - 1) && (ladyBugsArr[ladybugIndex].equals("1"))) {
                String direction = flyArray[1];
                ladyBugsArr[ladybugIndex] = "0";
                switch (direction) {
                    case "right":
                        while ((ladybugIndex + flyLength) <= (ladyBugsArr.length - 1)) {                        //for (int j = ladybugIndex; j < ladyBugsArr.length; j++) {

                            temp = ladyBugsArr[ladybugIndex + flyLength];
                            if (temp.equals("0")) {
                                ladyBugsArr[ladybugIndex + flyLength] = "1";
                                break;
                            } else {
                                ladybugIndex = ladybugIndex + flyLength;
                            }

                        }

                        break;
                    case "left":
                        while ((ladybugIndex - flyLength) >= 0) {
                            temp = ladyBugsArr[ladybugIndex - flyLength];
                            if (temp.equals("0")) {
                                ladyBugsArr[ladybugIndex - flyLength] = "1";
                                break;
                            } else {
                                ladybugIndex = ladybugIndex - flyLength;
                            }

                        }
                        break;
                }


            }

            inputLine = scanner.nextLine();
        }
        for (String item : ladyBugsArr) {
            System.out.print(item + " ");

        }
    }
}
