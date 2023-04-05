package glacialExpedition;

import glacialExpedition.core.Controller;
import glacialExpedition.core.ControllerImpl;
import glacialExpedition.core.Engine;
import glacialExpedition.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
