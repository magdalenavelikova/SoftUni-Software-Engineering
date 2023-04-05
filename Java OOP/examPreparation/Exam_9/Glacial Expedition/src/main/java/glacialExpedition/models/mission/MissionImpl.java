package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;

public class MissionImpl implements Mission {
    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        Collection<String> exhibits = state.getExhibits();


        for (Explorer explorer : explorers) {
            while (explorer.canSearch() && exhibits.iterator().hasNext()) {
                explorer.search();
                String current = exhibits.iterator().next();
                explorer.getSuitcase().getExhibits().add(current);
                exhibits.remove(current);
            }
        }
    }
}
