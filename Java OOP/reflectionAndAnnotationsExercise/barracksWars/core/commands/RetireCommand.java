package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class RetireCommand extends Command {
    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        try {
            getRepository().removeUnit(getData()[1]);
            return String.format("%s retired!", unitType);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }

    }
}
