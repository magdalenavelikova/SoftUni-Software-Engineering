package workngWithAbstractionExercise.cardsWithPower;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CardRank cardRank = CardRank.parse(scanner.nextLine());
        CardSuits cardSuits = CardSuits.parse(scanner.nextLine());
        Card card = new Card(cardRank, cardSuits);

        System.out.printf("Card name: %s of %s; Card power: %d", cardRank.name(), cardSuits.name(), card.getCardPower());

    }
}
