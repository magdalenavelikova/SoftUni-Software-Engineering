package associativeArraysExercise;

import java.util.*;


public class SoftUniExamResults {
    public static class Student {
        private String username;
        private String language;
        private int points;

        public Student(String username, String language, int points) {
            this.username = username;
            this.language = language;
            this.points = points;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        List<Student> students = new ArrayList<>();
        Map<String, Integer> submissionsCounterByLanguage = new LinkedHashMap<>();
        while (!command.equals("exam finished")) {
            boolean isExist = false;
            if (command.contains("banned")) {
                String username = command.split("-")[0];
                if (!students.isEmpty()) {
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getUsername().equals(username)) {
                            students.remove(i);
                            i -= 1;
                        }
                    }
                }
            } else {
//                "{username}-{language}-{points}"
                String username = command.split("-")[0];
                String language = command.split("-")[1];
                int points = Integer.parseInt(command.split("-")[2]);
                Student student = new Student(username, language, points);
                if (!students.isEmpty()) {
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getUsername().equals(username) && students.get(i).getLanguage().equals(language)) {
                            if (students.get(i).getPoints() < points) {
                                students.set(i, student);
                            }
                            isExist = true;
                            break;
                        }
                    }

                    if (!isExist) {
                        students.add(student);
                    }
                } else {
                    students.add(student);
                }
                submissionsCounterByLanguage.putIfAbsent(language, 0);
                int counter = submissionsCounterByLanguage.get(language);
                submissionsCounterByLanguage.put(language, counter + 1);

            }
            command = scanner.nextLine();
        }

        if (!students.isEmpty()) {
            System.out.println("Results:");
//Peter | 84
            students.forEach(s -> System.out.println(s.getUsername() + " | " + s.getPoints()));
        }
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : submissionsCounterByLanguage.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }


    }
}
