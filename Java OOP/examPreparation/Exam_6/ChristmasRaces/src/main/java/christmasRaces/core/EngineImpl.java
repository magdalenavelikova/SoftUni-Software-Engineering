package christmasRaces.core;

import christmasRaces.common.Command;
import christmasRaces.core.interfaces.Controller;
import christmasRaces.core.interfaces.Engine;
import christmasRaces.io.interfaces.InputReader;
import christmasRaces.io.interfaces.OutputWriter;

import java.io.IOException;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private InputReader reader;
    private OutputWriter writer;
    private Controller controller;

    public EngineImpl(InputReader reader, OutputWriter writer, Controller controller) {
        this.reader = reader;
        this.writer = writer;
        this.controller = controller;
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.End.name())) {
                    break;
                }

            } catch (IOException | IllegalArgumentException | NullPointerException e) {
                result = e.getMessage();
            }

            this.writer.writeLine(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        String result = null;

        switch (command) {
            case AddDriverToRace:
                result = this.addDriver(data);
                break;
            case End:
                result = Command.End.name();
                break;
            case StartRace:
                result = this.startRace(data);
                break;
            case CreateDriver:
                result = this.createDriver(data);
                break;
            case AddCarToDriver:
                result = this.addCar(data);
                break;
            case CreateCar:
                result = this.createCar(data);
                break;
            case CreateRace:
                result = this.createRace(data);
                break;
        }
        return result;
    }

    private String createRace(String[] data) {

        return controller.createRace(data[0],Integer.parseInt(data[1]));
    }

    private String addDriver(String[] data) {

        return controller.addDriverToRace(data[0],data[1]);
    }

    private String startRace(String[] data) {

        return controller.startRace(data[0]);
    }

    private String addCar(String[] data) {

        return controller.addCarToDriver(data[0],data[1]);
    }

    private String createCar(String[] data) {

        return controller.createCar(data[0],data[1],Integer.parseInt(data[2]));
    }

    private String createDriver(String[] data) {

        return controller.createDriver(data[0]);
    }
}
