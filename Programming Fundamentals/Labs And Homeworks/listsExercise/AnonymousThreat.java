package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stringsList = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("3:1")) {
//•	merge {startIndex} {endIndex}
            if (command.contains("merge")) {
                int startIndex = Integer.parseInt(command.split(" ")[1]);
                int endIndex = Integer.parseInt(command.split(" ")[2]);
                if (startIndex < 0) {
                    startIndex = 0;
                }
                if (endIndex > stringsList.size() - 1) {
                    endIndex = stringsList.size() - 1;
                }
                String result = "";
                if (endIndex >= 0 && startIndex <= stringsList.size() - 1) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        result += stringsList.get(i);
                    }
                    for (int i = startIndex; i <= endIndex; i++) {
                        stringsList.remove(startIndex);
                    }
                    stringsList.add(startIndex, result);

                }

            } else if (command.contains("divide")) {
//                •	divide {index} {partitions}
                int index = Integer.parseInt(command.split(" ")[1]);
                int partitions = Integer.parseInt(command.split(" ")[2]);
                 if (isValidIndex(stringsList.size(), index)) {
                String element = stringsList.get(index);
                stringsList.remove(index);
                int countElements = element.length() / partitions;
                int beginIndex = 0;
                for (int i = 1; i < partitions; i++) {
                    stringsList.add(index, element.substring(beginIndex, beginIndex + countElements));
                    index++;
                    beginIndex += countElements;
                }
                stringsList.add(index, element.substring(beginIndex));
               }
            }
            command = scanner.nextLine();
        }
        System.out.print(stringsList.toString().replaceAll("[\\[\\],]", ""));
     //   System.out.println(String.join(" ", stringsList));- още един начин за печат на List от стрингове
    }

    public static boolean isValidIndex(int size, int position) {
        return (position >= 0 && position < size);
    }
}
