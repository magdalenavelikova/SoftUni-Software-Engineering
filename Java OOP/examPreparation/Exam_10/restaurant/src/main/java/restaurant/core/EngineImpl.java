package restaurant.core;

import restaurant.common.enums.Commands;
import restaurant.core.interfaces.Controller;
import restaurant.core.interfaces.Engine;
import restaurant.io.ConsoleReader;
import restaurant.io.ConsoleWriter;

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

            case addHealthyFood:
            result = this.controller.addHealthyFood(
                    data[0], Double.parseDouble(data[1]), data[2]
            );
            break;

            case addBeverage:
                result = this.controller.addBeverage(
                        data[0], Integer.parseInt(data[1]), data[2],  data[3]
                );
                break;

            case addTable:
                result = this.controller.addTable(
                        data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])
                );
                break;
            case reserve:
                result = this.controller.reserve(Integer.parseInt(data[0]));
                break;
            case orderHealthyFood:
                result = this.controller.orderHealthyFood(Integer.parseInt(data[0]), data[1]);
                break;
            case orderBeverage:
                result = this.controller.orderBeverage(Integer.parseInt(data[0]), data[1], data[2]);
                break;
            case closedBill:
                result = this.controller.closedBill(Integer.parseInt(data[0]));
                break;
            case totalMoney:
                result = this.controller.totalMoney();
                break;
            case END:
                result = Commands.END.name();
                break;
        }
        return result.trim();
    }

}
