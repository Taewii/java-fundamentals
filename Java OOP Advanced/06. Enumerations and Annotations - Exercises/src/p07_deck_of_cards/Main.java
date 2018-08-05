package p07_deck_of_cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String input = reader.readLine();

        Suit[] suits = Suit.values();
        Rank[] ranks = Rank.values();

        for (Suit suit : suits) {
            for (Rank rank : ranks) {
                System.out.printf("%s of %s%n", rank, suit);
            }
        }
    }
}
