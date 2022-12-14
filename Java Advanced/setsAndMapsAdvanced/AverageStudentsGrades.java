package setsAndMapsAdvanced;

import java.util.*;

public class AverageStudentsGrades {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> gradesByStudentsName = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            double grade = Double.parseDouble(input.split("\\s+")[1]);
            gradesByStudentsName.putIfAbsent(name, new ArrayList<>());
            gradesByStudentsName.get(name).add(grade);

        }

        for (Map.Entry<String, List<Double>> entry : gradesByStudentsName.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            double sumOfGrades = 0;
            for (Double grade : entry.getValue()) {
                System.out.printf("%.2f ", grade);
                sumOfGrades += grade;

            }
            System.out.printf("(avg: %.2f)%n", sumOfGrades / entry.getValue().size());
        }
    }
}
