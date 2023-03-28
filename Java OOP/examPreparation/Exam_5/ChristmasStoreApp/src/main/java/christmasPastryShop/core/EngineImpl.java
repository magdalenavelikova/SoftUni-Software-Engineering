package christmasPastryShop.core;

import christmasPastryShop.common.enums.Commands;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.core.interfaces.Engine;
import christmasPastryShop.io.ConsoleReader;
import christmasPastryShop.io.ConsoleWriter;

import java.io.IOException;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private ConsoleReader reader;
    private ConsoleWriter writer;
    private Controller controller;

    public EngineImpl(ConsoleReader reader, ConsoleWriter writer, Controller controller) {
        this.reader = reader;
        this.writer = writer;
        this.controller = controller;
    }

    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Commands.END.name())) {
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

        Commands command = Commands.valueOf(tokens[0]);
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        String result = null;

        switch (command) {
            case AddCocktail:
                result = this.controller.addCocktail(
                        data[0], data[1], Integer.parseInt(data[2]), data[3]);
                break;
            case AddDelicacy:
                result = this.controller.addDelicacy(
                        data[0], data[1], Double.parseDouble(data[2]));
                break;
            case AddBooth:
                result = this.controller.addBooth(
                        data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]));
                break;
            case ReserveBooth:
                result = this.controller.reserveBooth(Integer.parseInt(data[0]));
                break;
            case LeaveBooth:
                result = this.controller.leaveBooth(Integer.parseInt(data[0]));
                break;
            case GetIncome:
                result = this.controller.getIncome();
                break;
            case END:
                result = Commands.END.name();
                break;
        }


        return result.trim();
    }

}
