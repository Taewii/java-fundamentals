package p03_cards_with_power;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String rank = reader.readLine();
        String suit = reader.readLine();

        System.out.printf("Card name: %s of %s; Card power: %d", rank, suit,
                Rank.valueOf(rank).getRankPower() + Suit.valueOf(suit).getSuitPower());
    }
}
