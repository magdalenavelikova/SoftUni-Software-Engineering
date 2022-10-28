package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> scheduleList = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.contains("course start")) {
            if (command.contains("Add")) { //Add:{lessonTitle} - add the lesson to the end of the schedule, if it does not exist
                String lessonTitle = command.split(":")[1];
                if (!scheduleList.contains(lessonTitle)) {
                    scheduleList.add(lessonTitle);
                }
            } else if (command.contains("Insert")) {//Insert:{lessonTitle}:{index} -insert the lesson to the given index, if it does not exist
                String lessonTitle = command.split(":")[1];
                int index = Integer.parseInt(command.split(":")[2]);
                if (!scheduleList.contains(lessonTitle)) {
                    scheduleList.add(index, lessonTitle);
                }
            } else if (command.contains("Remove")) {//Remove:{lessonTitle} -remove the lesson, if it exists
                String lessonTitle = command.split(":")[1];
                if (scheduleList.contains(lessonTitle)) {
                    scheduleList.removeIf(e -> e.equals(lessonTitle));
                }
            } else if (command.contains("Swap")) {//Swap:{lessonTitle}:{lessonTitle} -change the place of the two lessons, if they exist
                String lessonTitleForSwapFirst = command.split(":")[1];
                String lessonTitleForSwapSecond = command.split(":")[2];
                if (scheduleList.contains(lessonTitleForSwapFirst) && scheduleList.contains(lessonTitleForSwapSecond)) {
                    if ((!scheduleList.contains(lessonTitleForSwapFirst + "-Exercise") && !scheduleList.contains(lessonTitleForSwapSecond + "-Exercise"))) {
                        int indexFirstElement = scheduleList.indexOf(lessonTitleForSwapFirst);
                        int indexSecondElement = scheduleList.indexOf(lessonTitleForSwapSecond);
                        scheduleList.set(indexFirstElement, lessonTitleForSwapSecond);
                        scheduleList.set(indexSecondElement, lessonTitleForSwapFirst);
                    } else if (scheduleList.contains(lessonTitleForSwapFirst + "-Exercise")) {
                        String exerciseTitleForSwapFirst = lessonTitleForSwapFirst + "-Exercise";
                        int indexFirstElement = scheduleList.indexOf(lessonTitleForSwapFirst);
                        int indexFirstExercise = scheduleList.indexOf(exerciseTitleForSwapFirst);
                        int indexSecondElement = scheduleList.indexOf(lessonTitleForSwapSecond);
                        scheduleList.set(indexFirstElement, lessonTitleForSwapSecond);
                        scheduleList.set(indexSecondElement, lessonTitleForSwapFirst);
                        scheduleList.add(indexSecondElement + 1, exerciseTitleForSwapFirst);
                        scheduleList.remove(indexFirstExercise+1);
                    } else if (scheduleList.contains(lessonTitleForSwapSecond + "-Exercise")) {
                        String exerciseTitleForSwapSecond = lessonTitleForSwapSecond + "-Exercise";
                        int indexFirstElement = scheduleList.indexOf(lessonTitleForSwapFirst);
                        int indexSecondElement = scheduleList.indexOf(lessonTitleForSwapSecond);
                        int indexSecondExercise = scheduleList.indexOf(exerciseTitleForSwapSecond);
                        scheduleList.set(indexFirstElement, lessonTitleForSwapSecond);
                        scheduleList.set(indexSecondElement, lessonTitleForSwapFirst);
                        scheduleList.add(indexFirstElement + 1, exerciseTitleForSwapSecond);
                        scheduleList.remove(indexSecondExercise+1);
                    } else {
                        String exerciseTitleForSwapSecond = lessonTitleForSwapSecond + "-Exercise";
                        String exerciseTitleForSwapFirst = lessonTitleForSwapFirst + "-Exercise";
                        int indexFirstElement = scheduleList.indexOf(lessonTitleForSwapFirst);
                        int indexFirstExercise = scheduleList.indexOf(exerciseTitleForSwapFirst);
                        int indexSecondElement = scheduleList.indexOf(lessonTitleForSwapSecond);
                        int indexSecondExercise = scheduleList.indexOf(exerciseTitleForSwapSecond);
                        scheduleList.set(indexFirstElement, lessonTitleForSwapSecond);
                        scheduleList.set(indexSecondElement, lessonTitleForSwapFirst);
                        scheduleList.set(indexFirstExercise, exerciseTitleForSwapSecond);
                        scheduleList.set(indexSecondExercise, exerciseTitleForSwapFirst);
                    }
                }
            } else if (command.contains("Exercise")) {
                String lessonTitle = command.split(":")[1];
                String stringToInput = lessonTitle + "-Exercise";
                if (!scheduleList.contains(lessonTitle)) {
                    scheduleList.add(lessonTitle);
                    scheduleList.add(stringToInput);
                } else {
                    if (!scheduleList.contains(stringToInput)) {
                        scheduleList.add((scheduleList.indexOf(lessonTitle) + 1), stringToInput);
                    }
                }
            }
//Exercise:{lessonTitle} -add Exercise in the schedule right after the lesson index, if the lesson exists and there is no exercise already, in the following format "{lessonTitle}-Exercise". If the lesson doesn't exist, add the lesson at the end of the course schedule, followed by the Exercise.
            command = scanner.nextLine();

        }
        for (int i = 0; i < scheduleList.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, scheduleList.get(i));

        }
    }
}
