package workngWithAbstractionExercise.trafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<TrafficLight> trafficLightList=new ArrayList<>();
        String[] input = scanner.nextLine().split("\\s+");

        fillTheList(trafficLightList, input);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            for (TrafficLight trafficLight : trafficLightList) {
               trafficLight.updateTrafficLight();
                System.out.print(trafficLight.signals.name()+" ");
            }
            System.out.println();
        }

    }

    private static void fillTheList(List<TrafficLight> trafficLightList, String[] input) {
        for (String str : input) {
            Signals signals = Signals.parse(str);
            TrafficLight trafficLight=new TrafficLight(signals);
            trafficLightList.add(trafficLight);
        }
    }
}
