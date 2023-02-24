package associativeArraysExercise;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> studentsByCourses = new LinkedHashMap<>();
        String inputLine = scanner.nextLine();

        while (!inputLine.equals("end")) {
            String course = inputLine.split(" : ")[0];
            String student = inputLine.split(" : ")[1];
         /*   List<String> students=studentsByCourses.get(course);
            if(students!=null){
                studentsByCourses.get(course).add(student);
            }else{
                students=new ArrayList<>();
                students.add(student);
                studentsByCourses.put(course,students);
            }*/
            studentsByCourses.putIfAbsent(course, new ArrayList<>());
            studentsByCourses.get(course).add(student);

            inputLine = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : studentsByCourses.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
            for (String s : entry.getValue()) {
                System.out.printf(" -- %s%n", s);

            }
        }
    }
}
