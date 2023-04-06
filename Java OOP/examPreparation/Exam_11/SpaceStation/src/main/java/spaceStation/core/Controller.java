package spaceStation.core;

public interface Controller {
    String addAstronaut(String type, String astronautName);

    String addPlanet(String planetName, String... items);

    String retireAstronaut(String astronautName);

    String explorePlanet(String planetName);

    String report();
}
