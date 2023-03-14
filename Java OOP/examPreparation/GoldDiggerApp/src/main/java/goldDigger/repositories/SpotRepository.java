package goldDigger.repositories;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class SpotRepository implements Repository<Spot> {
    Map<String, Spot> spots;

    public SpotRepository() {
        this.spots = new LinkedHashMap<>();
    }

    @Override
    public Collection getCollection() {
           return Collections.unmodifiableCollection(spots.values());
    }

    @Override
    public void add(Spot spot) {
        String name = spot.getName();
        spots.put(name, spot);

    }

    @Override
    public boolean remove(Spot spot) {
        return spots.remove(spot.getName(), spot);
    }

    @Override
    public Spot byName(String name) {
        return spots.get(name);
    }
}
