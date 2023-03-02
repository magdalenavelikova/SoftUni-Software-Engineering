package reflectionAndAnnotationsExercise.barracksWars.core.commands;

import reflectionAndAnnotationsExercise.barracksWars.annotations.Inject;
import reflectionAndAnnotationsExercise.barracksWars.interfaces.Repository;

public class ReportCommand extends Command {
    @Inject
    private Repository repository;

    public ReportCommand(String[] data) {
        super(data);

    }

    @Override
    public String execute() {
        return repository.getStatistics();

    }
}
