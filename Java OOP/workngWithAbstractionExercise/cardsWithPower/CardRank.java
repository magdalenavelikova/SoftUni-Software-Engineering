package workngWithAbstractionExercise.cardsWithPower;


public enum CardRank {

    ACE(14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int power;

    CardRank(int power) {
        this.power = power;
    }

    public static CardRank parse(String string) {
        return CardRank.valueOf(string);
    }

    public int getPower() {
        return power;
    }
}
