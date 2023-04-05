package catHouse.core;

import catHouse.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {

        this.controller = new ControllerImpl(); // TODO: Implement ControllerImpl before starting the application.
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals("End")) {
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
            case AddHouse:
                result = addHouse(data);
                break;
            case BuyToy:
                result = buyToy(data);
                break;
            case ToyForHouse:
                result = toyForHouse(data);
                break;
            case AddCat:
                result = addCat(data);
                break;
            case FeedingCat:
                result = feedingCat(data);
                break;
            case SumOfAll:
                result = sumOfAll(data);
                break;
            case Statistics:
                result = getStatistics();
                break;
            case End:
                result = Command.End.name();
                break;
        }
        return result;
    }

    private String addHouse(String[] data) {
       return this.controller.addHouse(data[0], data[1]);
    }

    private String buyToy(String[] data) {
        return this.controller.buyToy(data[0]);
    }

    private String toyForHouse(String[] data) {
        return this.controller.toyForHouse(data[0], data[1]);
    }

    private String addCat(String[] data) {
        return this.controller.addCat(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]));
    }

    private String feedingCat(String[] data) {
        return this.controller.feedingCat(data[0]);
    }

    private String sumOfAll(String[] data) {
        return this.controller.sumOfAll(data[0]);
    }

    private String getStatistics() {
        return this.controller.getStatistics();
    }
}

