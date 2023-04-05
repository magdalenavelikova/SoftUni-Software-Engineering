package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;

import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ExplorerRepository explorers;
    private StateRepository states;
    private int exploredStatesCount;

    public ControllerImpl() {
        this.explorers = new ExplorerRepository();
        this.states = new StateRepository();
        this.exploredStatesCount = 0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        if (type.equals("AnimalExplorer")) {
            explorer = new AnimalExplorer(explorerName);
        } else if (type.equals("NaturalExplorer")) {
            explorer = new NaturalExplorer(explorerName);
        } else if (type.equals("GlacierExplorer")) {
            explorer = new GlacierExplorer(explorerName);
        } else {
            throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }
        explorers.add(explorer);
        return String.format(String.format(EXPLORER_ADDED, type, explorerName));
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        StateImpl state = new StateImpl(stateName);
        for (String ex : exhibits) {
            state.getExhibits().add(ex);
        }
        states.add(state);
        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorers.byName(explorerName);
        if (explorer == null) {
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        explorers.remove(explorer);
        return String.format(EXPLORER_RETIRED, explorerName);

    }

    @Override
    public String exploreState(String stateName) {
        State state = states.byName(stateName);
        List<Explorer> availableExplorers = explorers.getCollection().stream()
                .filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());
        if (availableExplorers.isEmpty()) {
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        Mission mission = new MissionImpl();
        mission.explore(state, availableExplorers);
        List<Explorer> retired = explorers.getCollection()
                .stream().filter(e -> !e.canSearch())
                .collect(Collectors.toList());
        retired.forEach(r -> {
            String name = r.getName();
            retireExplorer(name);
        });
        exploredStatesCount++;
        return String.format(STATE_EXPLORER, stateName, retired.size());
    }

    @Override
    public String finalResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_STATE_EXPLORED, exploredStatesCount)).append(System.lineSeparator());
        sb.append(FINAL_EXPLORER_INFO).append(System.lineSeparator());
        explorers.getCollection().forEach(e -> sb.append(e.toString()).append(System.lineSeparator()));
        return sb.toString().trim();


    }
}
