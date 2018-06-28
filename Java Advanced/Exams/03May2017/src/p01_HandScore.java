import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class p01_HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String[] cards = reader.readLine().split(" ");

        int totalSum = 0;
        int currentSum = 0;
        int counter = 0;
        char previousSuit = ' ';

        for (String card : cards) {
            int face = cardFace(card);
            char suit = card.length() == 3 ? card.charAt(2) : card.charAt(1);

            if (previousSuit == ' ' || previousSuit == suit) {
                currentSum += face;
                previousSuit = suit;
                counter++;
            } else {
                totalSum += counter > 0 ? currentSum * counter : currentSum;
                currentSum = face;
                previousSuit = suit;
                counter = 1;
            }
        }

        totalSum += counter > 0 ? currentSum * counter : currentSum;
        System.out.println(totalSum);
    }

    private static int cardFace(String card) {
        if (card.length() == 3) {
            return 10;
        }
        int face;
        char suit = card.charAt(0);
        switch (suit) {
            case 'J': face = 12; break;
            case 'Q': face = 13; break;
            case 'K': face = 14; break;
            case 'A': face = 15; break;
            default: return Integer.parseInt(suit + "");
        }
        return face;
    }
}