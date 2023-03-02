package barracksWars;

import barracksWars.core.commands.CommandInterpreterImpl;
import barracksWars.interfaces.*;
import barracksWars.core.Engine;
import barracksWars.core.factories.UnitFactoryImpl;
import barracksWars.data.UnitRepository;
import barracksWars.interfaces.Runnable;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter=new CommandInterpreterImpl(repository,unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();

    }
}
