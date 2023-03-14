package zoo.core;

import zoo.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals("Exit")) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddArea:
                result = addArea(data);
                break;
            case BuyFood:
                result = buyFood(data);
                break;
            case FoodForArea:
                result = foodForArea(data);
                break;
            case AddAnimal:
                result = addAnimal(data);
                break;
            case FeedAnimal:
                result = feedAnimal(data);
                break;
            case CalculateKg:
                result = calculateKg(data);
                break;
            case GetStatistics:
                result = getStatistics();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }

    private String addArea(String[] data) {

        return controller.addArea(data[0], data[1]);
    }

    private String buyFood(String[] data) {

        return controller.buyFood(data[0]);
    }

    private String foodForArea(String[] data) {
        return controller.foodForArea(data[0], data[1]);
    }

    private String addAnimal(String[] data) {
        return controller.addAnimal(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]));
    }

    private String feedAnimal(String[] data) {

        return controller.feedAnimal(data[0]);
    }

    private String calculateKg(String[] data) {

        return controller.calculateKg(data[0]);
    }

    private String getStatistics() {

        return controller.getStatistics();
    }
}