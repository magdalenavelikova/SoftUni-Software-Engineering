package workngWithAbstractionExercise.greedyTimes;

public enum Type {
    GOLD,
    GEM,
    CASH;

    public static Type parse(String string) {
        if (string.length() == 3) {
            return Type.valueOf("CASH");
        } else if (string.length() >= 4 && string.toLowerCase().endsWith("gem")) {
            return Type.valueOf("GEM");
        } else if (string.equalsIgnoreCase("Gold")) {
            return Type.valueOf("GOLD");
        } else {
            throw new IllegalArgumentException("Unknown Type!");
        }
    }


}
