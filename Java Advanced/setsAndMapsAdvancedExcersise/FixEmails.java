package setsAndMapsAdvancedExcersise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, String> contacts = new LinkedHashMap<>();


        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();
            if (!email.endsWith(".us") && !email.endsWith(".com") && !email.endsWith(".uk")) {
                contacts.put(name, email);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, String> e : contacts.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}