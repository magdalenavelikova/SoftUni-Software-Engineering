package workngWithAbstractionExercise.cardsWithPower;

public enum CardSuits {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);
    private int power;

    CardSuits(int power) {
        this.power = power;
    }

    public static CardSuits parse(String string) {
        return CardSuits.valueOf(string);
    }

    public int getPower() {
        return power;
    }
}
