package setsAndMapsAdvanced;

import java.util.*;

public class AcademyGraduation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> averageGradeByStudents = new TreeMap<>();

        while (--n >= 0) {
            String name = scanner.nextLine();
            double[] grades = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            averageGradeByStudents.putIfAbsent(name, new ArrayList<>());
            for (double grade : grades) {
                averageGradeByStudents.get(name).add(grade);
            }

        }
        averageGradeByStudents.forEach((key, value) -> {
            double sumOfGrades = 0;
            for (Double grade : value) {
                sumOfGrades += grade;
            }
            System.out.printf("%s is graduated with %s%n", key, sumOfGrades / value.size());
        });
    }
}
