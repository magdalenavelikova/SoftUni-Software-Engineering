package reflectionAndAnnotationsExercise.barracksWars.core.commands;

import reflectionAndAnnotationsExercise.barracksWars.annotations.Inject;
import reflectionAndAnnotationsExercise.barracksWars.interfaces.Repository;
import reflectionAndAnnotationsExercise.barracksWars.interfaces.Unit;
import reflectionAndAnnotationsExercise.barracksWars.interfaces.UnitFactory;

public class AddCommand extends Command {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        Unit unitToAdd = unitFactory.createUnit(unitType);
        repository.addUnit(unitToAdd);
        return unitType + " added!";

    }
}
