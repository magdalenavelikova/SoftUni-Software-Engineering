package setsAndMapsAdvancedExcersise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Integer>> ipByUsers = new TreeMap<>();

        while (!input.equals("end")) {
            String ip = input.split("\\s+")[0].split("=")[1];
            String username = input.split("\\s+")[2].split("=")[1];

            ipByUsers.putIfAbsent(username, new LinkedHashMap<>());

            if (ipByUsers.get(username).containsKey(ip)) {
                ipByUsers.get(username).put(ip, ipByUsers.get(username).get(ip) + 1);
            } else {
                ipByUsers.get(username).put(ip, 1);
            }

            input = scanner.nextLine();
        }

        ipByUsers.forEach((key, value) -> {
            System.out.println(key + ": ");
            final int[] counter = {value.size()};

            for (Map.Entry<String, Integer> ip : value.entrySet()) {

                if (counter[0] > 1) {
                    System.out.print(ip.getKey() + " => " + ip.getValue() + ", ");
                } else {
                    System.out.print(ip.getKey() + " => " + ip.getValue() + ".");
                }
                counter[0]--;
            }
            System.out.println();
        });
    }
}
