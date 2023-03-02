package reflectionAndAnnotationsExercise.barracksWars;

import reflectionAndAnnotationsExercise.barracksWars.core.commands.CommandInterpreterImpl;
import reflectionAndAnnotationsExercise.barracksWars.interfaces.*;
import reflectionAndAnnotationsExercise.barracksWars.core.Engine;
import reflectionAndAnnotationsExercise.barracksWars.core.factories.UnitFactoryImpl;
import reflectionAndAnnotationsExercise.barracksWars.data.UnitRepository;
import reflectionAndAnnotationsExercise.barracksWars.interfaces.Runnable;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter=new CommandInterpreterImpl(repository,unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();

    }
}
