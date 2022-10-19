package midExam;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        for (int i = 0; i < integerList.size(); i++) {
            sum += integerList.get(i);
        }
        double average = sum * 1.0 / integerList.size();
        List<Integer> top5 = new ArrayList<>();

        for (int i = 0; i < integerList.size(); i++) {
            if (integerList.get(i) > average) {
                top5.add(integerList.get(i));
            }
        }
        Collections.sort(top5);
        Collections.reverse(top5);

        if (top5.isEmpty()) {
            System.out.println("No");
        } else if (top5.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                System.out.print(top5.get(i) + " ");
            }
        } else {
            for (int item : top5) {
                System.out.print(item + " ");

            }
        }
    }
}
