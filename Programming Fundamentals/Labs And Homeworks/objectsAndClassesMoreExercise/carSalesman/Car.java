package objectsAndClassesMoreExercise.carSalesman;

public class Car {
    //    Car has a model, engine, weight, and color
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car() {

    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    /*{CarModel}:
      {EngineModel}:
        Power: {EnginePower}
        Displacement: {EngineDisplacement}
        Efficiency: {EngineEfficiency}
      Weight: {CarWeight}
      Color: {CarColor}"
    */
    public boolean isCarWightZero() {
        if (this.weight == 0) {
            return true;

        }
        return false;
    }

    public boolean isEngineDisplacementZero() {
        if (this.engine.getDisplacement() == 0) {
            return true;

        }
        return false;
    }

    @Override
    public String toString() {
        String outputForZero = "n/a";
        if (isCarWightZero() && isEngineDisplacementZero()) {

            return String.format("%s:%n" +
                            " %s:%n" +
                            "  Power: %d%n" +
                            "  Displacement: %s%n" +
                            "  Efficiency: %s%n" +
                            " Weight: %s%n" +
                            " Color: %s"
                    , this.model, engine.getModel(), engine.getPower(), outputForZero, engine.getEfficiency(), outputForZero, this.color);

        } else if (isEngineDisplacementZero()) {

            return String.format("%s:%n" +
                            " %s:%n" +
                            "  Power: %d%n" +
                            "  Displacement: %s%n" +
                            "  Efficiency: %s%n" +
                            " Weight: %d%n" +
                            " Color: %s"
                    , this.model, engine.getModel(), engine.getPower(), outputForZero, engine.getEfficiency(), this.weight, this.color);

        } else if(isCarWightZero()) {
            return String.format("%s:%n" +
                            " %s:%n" +
                            "  Power: %d%n" +
                            "  Displacement: %d%n" +
                            "  Efficiency: %s%n" +
                            " Weight: %s%n" +
                            " Color: %s"
                    , this.model, engine.getModel(), engine.getPower(), engine.getDisplacement(), engine.getEfficiency(), outputForZero, this.color);

        }
        else {

            return String.format("%s:%n" +
                            " %s:%n" +
                            "  Power: %d%n" +
                            "  Displacement: %d%n" +
                            "  Efficiency: %s%n" +
                            " Weight: %d%n" +
                            " Color: %s"
                    , this.model, engine.getModel(), engine.getPower(), engine.getDisplacement(), engine.getEfficiency(), this.weight, this.color);
        }
    }
}
