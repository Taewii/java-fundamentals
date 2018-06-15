import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class p08_HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, Set<String>> players = new LinkedHashMap<>();

        String input;
        while (!"JOKER".equals(input = reader.readLine())) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");

            Set<String> playerCards = new HashSet<>(Arrays.asList(cards));

            if (!players.containsKey(name)) {
                players.put(name, playerCards);
            } else {
                players.get(name).addAll(playerCards);
            }
        }

        for (Map.Entry<String, Set<String>> playersEntry : players.entrySet()) {

            int sum = calculateSum(playersEntry);
            System.out.printf("%s: %d%n", playersEntry.getKey(), sum);
        }
    }

    private static int calculateSum(Map.Entry<String, Set<String>> playersEntry) {
        int sum = 0;
        int power = 0;
        int multiplier = 0;

        for (String card : playersEntry.getValue()) {
            char[] tokens = card.toCharArray();
            if (Character.isDigit(tokens[0])) {
                if (tokens.length == 3) {
                    power = 10;
                    tokens[1] = tokens[2];
                } else {
                    power = Integer.parseInt(tokens[0] + "");
                }
            } else {
                switch (tokens[0]) {
                    case 'J':
                        power = 11;
                        break;
                    case 'Q':
                        power = 12;
                        break;
                    case 'K':
                        power = 13;
                        break;
                    case 'A':
                        power = 14;
                        break;
                }
            }

            switch (tokens[1]) {
                case 'S':
                    multiplier = 4;
                    break;
                case 'H':
                    multiplier = 3;
                    break;
                case 'D':
                    multiplier = 2;
                    break;
                case 'C':
                    multiplier = 1;
                    break;
            }
            sum += power * multiplier;
        }
        return sum;
    }
}
