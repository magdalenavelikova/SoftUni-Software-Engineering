package catHouse;

import catHouse.core.Engine;
import catHouse.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
