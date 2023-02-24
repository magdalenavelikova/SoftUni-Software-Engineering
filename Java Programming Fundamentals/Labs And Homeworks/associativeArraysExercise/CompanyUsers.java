package associativeArraysExercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> idByCompanies = new LinkedHashMap<>();
        List<String> employers = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("->");
            for (int i = 0; i < tokens.length; i++) {
                tokens[i] = tokens[i].trim();
            }
            String companyName = tokens[0];
            String employeeId = tokens[1];

            idByCompanies.putIfAbsent(companyName, new ArrayList<>());
            employers = idByCompanies.get(companyName);
            if (!employers.isEmpty()) {
                if (!employers.contains(employeeId)) {
                    idByCompanies.get(companyName).add(employeeId);
                }
            } else {
                idByCompanies.get(companyName).add(employeeId);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : idByCompanies.entrySet()) {
            System.out.println(entry.getKey());
            employers = entry.getValue();

            for (String s : employers) {
                System.out.printf("-- %s%n", s);
            }

        }

    }
}
