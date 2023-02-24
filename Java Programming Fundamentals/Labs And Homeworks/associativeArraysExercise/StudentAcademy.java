package associativeArraysExercise;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> gradeByStudents = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            gradeByStudents.putIfAbsent(name, new ArrayList<>());
            gradeByStudents.get(name).add(grade);
        }
        Map<String, Double> averageGradeByStudents = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : gradeByStudents.entrySet()) {
            double averageGrade = 0;
            for (Double grade : entry.getValue()) {
                averageGrade += grade;
            }
            averageGrade = averageGrade / entry.getValue().size();
            if (averageGrade >= 4.5) {
                averageGradeByStudents.put(entry.getKey(), averageGrade);
            }

        }
        for (Map.Entry<String, Double> entry : averageGradeByStudents.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
        }


    }
}
