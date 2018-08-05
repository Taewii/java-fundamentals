package p08_card_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String firstPlayer = reader.readLine();
        String secondPlayer = reader.readLine();
        List<Card> firstPlayerCards = new ArrayList<>();
        List<Card> secondPlayerCards = new ArrayList<>();
        List<Card> deck = new ArrayList<>();

        while (firstPlayerCards.size() < 5 || secondPlayerCards.size() < 5) {
            String[] input = reader.readLine().split(" ");

            try {
                Card card = new Card(input[0], input[2]);
                if (deck.contains(card)) {
                    System.out.println("Card is not in the deck.");
                } else {
                    deck.add(card);

                    if (firstPlayerCards.size() < 5) {
                        firstPlayerCards.add(card);
                    } else {
                        secondPlayerCards.add(card);
                    }
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("No such card exists.");
            }
        }

        Optional<Card> firstPlayerBestCard = firstPlayerCards.stream().max(Comparator.comparingInt(Card::getPower));
        Optional<Card> secondPlayerBestCard = secondPlayerCards.stream().max(Comparator.comparingInt(Card::getPower));

        if (firstPlayerBestCard.get().getPower() > secondPlayerBestCard.get().getPower()) {
            System.out.printf("%s wins with %s.", firstPlayer, firstPlayerBestCard.get());
        } else {
            System.out.printf("%s wins with %s.", secondPlayer, secondPlayerBestCard.get());
        }
    }
}
