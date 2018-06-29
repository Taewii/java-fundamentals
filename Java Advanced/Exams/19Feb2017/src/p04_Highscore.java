import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class p04_Highscore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, List<String>> fights = new LinkedHashMap<>();
        Map<String, Long> totalScores = new LinkedHashMap<>();

        String input;
        while (!"osu!".equals(input = reader.readLine())) {
            String[] tokens = input.split("[<\\->\\s]+");
            String player1 = tokens[1];
            String player2 = tokens[2];
            int player1Score = Integer.parseInt(tokens[0]);
            int player2Score = Integer.parseInt(tokens[3]);

            fights.putIfAbsent(player1, new ArrayList<>());
            fights.putIfAbsent(player2, new ArrayList<>());
            totalScores.putIfAbsent(player1, 0L);
            totalScores.putIfAbsent(player2, 0L);

            if (player1Score > player2Score) {
                fights.get(player1).add(player2 + " <-> " + (player1Score - player2Score));
                fights.get(player2).add(player1 + " <-> " + (player2Score - player1Score));
                totalScores.put(player1, totalScores.get(player1) + (player1Score - player2Score));
                totalScores.put(player2, totalScores.get(player2) + (player2Score - player1Score));
            } else {
                fights.get(player2).add(player1 + " <-> " + (player2Score - player1Score));
                fights.get(player1).add(player2 + " <-> " + (player1Score - player2Score));
                totalScores.put(player2, totalScores.get(player2) + (player2Score - player1Score));
                totalScores.put(player1, totalScores.get(player1) + (player1Score - player2Score));
            }
        }

        totalScores.entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .forEach(x -> {
                    System.out.printf("%s - (%d)%n", x.getKey(), x.getValue());
                    fights.get(x.getKey()).forEach(f -> System.out.println("*   " + f));
                });
    }
}
