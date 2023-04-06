package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.bags.Bag;
import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        List<Astronaut> availableAstronauts = astronauts.stream()
                .filter(a -> a.canBreath())
                .collect(Collectors.toList());
        Collection<String> items = planet.getItems();

        while (!availableAstronauts.isEmpty() && items.iterator().hasNext()) {
            Astronaut astronaut = availableAstronauts.get(0);
            String current = items.iterator().next();
            astronaut.breath();
            astronaut.getBag().getItems().add(current);
            items.remove(current);
            if (!astronaut.canBreath()) {
                availableAstronauts.remove(0);
            }
        }
    }
}
