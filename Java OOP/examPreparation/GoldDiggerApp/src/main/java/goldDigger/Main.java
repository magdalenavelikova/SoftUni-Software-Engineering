package goldDigger;

import goldDigger.core.Controller;
import goldDigger.core.ControllerImpl;
import goldDigger.core.Engine;
import goldDigger.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
