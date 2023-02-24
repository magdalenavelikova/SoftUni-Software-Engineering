package workngWithAbstractionExercise.cardSuit;

public class Main {

    public static void main(String[] args) {

        System.out.println("Card Suits:");

        for (CardsSuits suits : CardsSuits.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",suits.ordinal(),suits.name());
        }

    }

}
