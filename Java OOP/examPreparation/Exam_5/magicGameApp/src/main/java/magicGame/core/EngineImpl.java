package magicGame.core;

import magicGame.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl(); //TODO implement first
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

            } catch (IOException | IllegalArgumentException | NullPointerException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s");

        Command command = Command.valueOf(tokens[0]);
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        String result = null;

        switch (command) {
            case AddMagician:
                result = this.addMagician(data);
                break;
            case AddMagic:
                result = this.addMagic(data);
                break;
            case StartGame:
                result = this.start();
                break;
            case Report:
                result = this.report();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }

        return result;
    }

    private String addMagician(String[] data) {

        return controller.addMagician(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]),data[4]);
    }

    private String addMagic(String[] data) {
        return controller.addMagic(data[0], data[1], Integer.parseInt(data[2]));

    }

    private String start() {

        return controller.startGame();
    }

    private String report() {

        return controller.report();
    }
}
