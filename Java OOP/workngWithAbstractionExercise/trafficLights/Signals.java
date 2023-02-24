package workngWithAbstractionExercise.trafficLights;

public enum Signals {

    RED,
    GREEN,
    YELLOW;
    private static Signals[] values = values();

    public Signals next()
    {
        return values[(this.ordinal()+1) % values.length];
    }
    public static Signals parse(String str) {
        return Signals.valueOf(str);
    }



}
