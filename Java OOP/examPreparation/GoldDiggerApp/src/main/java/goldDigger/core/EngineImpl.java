package goldDigger.core;

import goldDigger.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine{
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
            case AddDiscoverer:
                result = addDiscoverer(data);
                break;
            case AddSpot:
                result = addSpot(data);
                break;
            case ExcludeDiscoverer:
                result = excludeDiscoverer(data);
                break;
            case InspectSpot:
                result = inspectSpot(data);
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

    private String excludeDiscoverer(String[] data) {
        return controller.excludeDiscoverer(data[0]);
    }

    private String getStatistics() {
        return controller.getStatistics();
    }

    private String inspectSpot(String[] data) {
        return controller.inspectSpot(data[0]);
    }

    private String addSpot(String[] data) {
        String spotName = data[0];
        String[] exhibits = Arrays.stream(data).skip(1).toArray(String[]::new);
        return controller.addSpot(spotName, exhibits);
    }

    private String addDiscoverer(String[] data) {
        return controller.addDiscoverer(data[0], data[1]);
    }

}
