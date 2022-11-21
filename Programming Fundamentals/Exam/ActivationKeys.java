package exam;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder rawActivationKey = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Generate")) {
            String command = input.split(">>>")[0];
            switch (command) {
                case "Contains":
                    String substring = input.split(">>>")[1];
                    if (rawActivationKey.toString().contains(substring)) {
                        System.out.printf("%s contains %s%n", rawActivationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String type = input.split(">>>")[1];
                    int startIndex = Integer.parseInt(input.split(">>>")[2]);
                    int endIndex = Integer.parseInt(input.split(">>>")[3]);
                    String string = rawActivationKey.substring(startIndex, endIndex);

                    if (type.equals("Upper")) {
                        rawActivationKey = new StringBuilder(rawActivationKey.toString().replace(string, string.toUpperCase()));
                    } else if (type.equals("Lower")) {
                        rawActivationKey = new StringBuilder(rawActivationKey.toString().replace(string, string.toLowerCase()));
                    }
                    System.out.println(rawActivationKey);
                    break;
                case "Slice":
                    int start = Integer.parseInt(input.split(">>>")[1]);
                    int end = Integer.parseInt(input.split(">>>")[2]);
                    rawActivationKey.delete(start, end);
                    System.out.println(rawActivationKey);
                    break;

            }
            input = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + rawActivationKey);
    }
}
