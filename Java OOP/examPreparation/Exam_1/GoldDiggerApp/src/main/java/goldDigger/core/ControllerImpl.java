package goldDigger.core;

import goldDigger.models.discoverer.*;


import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.*;
import goldDigger.repositories.DiscovererRepository;

import goldDigger.repositories.SpotRepository;


import java.util.*;
import java.util.stream.Collectors;


import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DiscovererRepository discoverers;
    private SpotRepository spots;
    private  int spotCount;

    public ControllerImpl() {
        this.discoverers = new DiscovererRepository();
        this.spots = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;
        if (kind.equals("Archaeologist")) {
            discoverer = new Archaeologist(discovererName);
        } else if (kind.equals("Anthropologist")) {
            discoverer = new Anthropologist(discovererName);
        } else if (kind.equals("Geologist")) {
            discoverer = new Geologist(discovererName);
        } else {
            throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }
        discoverers.add(discoverer);
        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);

        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }
        spots.add(spot);
        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        if (discoverers.byName(discovererName) == null) {
            throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        }
        discoverers.remove(discoverers.byName(discovererName));
        return String.format(DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        List<Discoverer> discovererList = new ArrayList<>(discoverers.getCollection());
        List<Discoverer> suitableDiscoverers = discovererList.stream()
                .filter(d -> d.getEnergy() > 45).collect(Collectors.toList());
        if (suitableDiscoverers.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        Operation operation = new OperationImpl();
        operation.startOperation(spots.byName(spotName), suitableDiscoverers);
        long count = suitableDiscoverers.stream().filter(d -> d.getEnergy() == 0).count();
        spotCount++;

        return String.format(INSPECT_SPOT, spotName, count);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format(FINAL_SPOT_INSPECT,spotCount));
        sb.append(System.lineSeparator());
        sb.append(FINAL_DISCOVERER_INFO).append(System.lineSeparator());
        List<Discoverer> discovererList = new ArrayList<>(discoverers.getCollection());

        for (Discoverer discoverer : discovererList) {
            sb.append(String.format(FINAL_DISCOVERER_NAME,discoverer.getName())).append(System.lineSeparator());
            sb.append(String.format(FINAL_DISCOVERER_ENERGY,discoverer.getEnergy())).append(System.lineSeparator());
            String museumReport =  discoverer.getMuseum().getExhibits().isEmpty()
                    ? "None"
                    : discoverer.getMuseum().getExhibits().stream()
                    .collect(Collectors.joining(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER));
            sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS,museumReport)).append(System.lineSeparator());

        }

        return sb.toString().trim();
    }
}
