package definingClassesExercise.carSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this(model, engine, -1, "n/a");
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, -1, color);
    }
public String wightToString(){
    if (weight!=-1) {
        return weight+"";
    }else {
        return "n/a";
    }
}

    @Override
    public String toString() {
        return model +":"+System.lineSeparator()+
                engine.getModel()+":"+System.lineSeparator()+
                "Power: " + engine.getPower() +System.lineSeparator()+
                "Displacement: " + engine.getDisplacement() +System.lineSeparator()+
                "Efficiency: " + engine.getEfficiency() +System.lineSeparator()+
                "Weight: " + wightToString() +System.lineSeparator()+
                "Color: " + color ;

    }
}
