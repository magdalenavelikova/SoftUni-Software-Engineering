package listsMoreExercise;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSetList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        List<Integer> usedDrumSetList = new ArrayList<>();
        for (int i = 0; i < drumSetList.size(); i++) {
            usedDrumSetList.add(drumSetList.get(i));
        }

        while (!input.equals("Hit it again, Gabsy!")) {
            int power = Integer.parseInt(input);
            int sizeOfList = usedDrumSetList.size();
            for (int i = 0; i < sizeOfList; i++) {

                if ((power >= usedDrumSetList.get(i))) {
                    int initiallyQuality = drumSetList.get(i);
                    double price = initiallyQuality * 3;
                    if (price <= savings) {
                        usedDrumSetList.set(i, initiallyQuality);
                        savings -= price;
                    } else {
                        usedDrumSetList.remove(i);
                        drumSetList.remove(i);
                        i -= 1;
                        sizeOfList -= 1;
                    }
                } else {
                    int currentQuality = usedDrumSetList.get(i) - power;
                    usedDrumSetList.set(i, currentQuality);
                }

            }


            input = scanner.nextLine();
        }
        System.out.println(usedDrumSetList.toString().replaceAll("[\\]\\[,]", ""));
        System.out.printf("Gabsy has %.2flv.", savings);
    }


}
