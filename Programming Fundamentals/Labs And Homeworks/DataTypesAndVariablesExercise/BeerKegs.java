package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        float maxVolume = Float.MIN_VALUE;
        String maxVolumeModel = "";
        for (int i = 0; i < n; i++) {
            float volume = 0;
            String model = scanner.nextLine();
            float radius = Float.parseFloat(scanner.nextLine());
            int hight = Integer.parseInt(scanner.nextLine());
            volume = (float) Math.PI * radius * radius * hight;
            if (volume > maxVolume) {
                maxVolume = volume;
                maxVolumeModel = model;
            }
        }
        System.out.println(maxVolumeModel);
    }
}
