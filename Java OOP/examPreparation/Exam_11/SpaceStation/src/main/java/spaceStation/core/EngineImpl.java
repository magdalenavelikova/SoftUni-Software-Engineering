package spaceStation.core;

import spaceStation.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl(Controller controller) {
        this.controller = controller;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
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
            case AddAstronaut:
                result = addAstronaut(data);
                break;
            case AddPlanet:
                result = addPlanet(data);
                break;
            case RetireAstronaut:
                result = retireAstronaut(data);
                break;
            case ExplorePlanet:
                result = explorePlanet(data);
                break;
            case Report:
                result = report();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }

        return result;
    }

    private String retireAstronaut(String[] data) {
        return controller.retireAstronaut(data[0]);
    }

    private String report() {
        return controller.report();
    }

    private String explorePlanet(String[] data) {
        return controller.explorePlanet(data[0]);
    }

    private String addPlanet(String[] data) {

        return controller.addPlanet(data[0],Arrays.stream(data).skip(1).toArray(String[]::new));
    }

    private String addAstronaut(String[] data) {
        return controller.addAstronaut(data[0], data[1]);
    }
}
