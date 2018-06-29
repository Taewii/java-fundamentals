import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.in;

public class p04_HighscoreClass {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, Player> players = new LinkedHashMap<>();

        String input;
        while (!"osu!".equalsIgnoreCase(input = reader.readLine())) {
            String[] tokens = input.split("[<\\->\\s]+");

            String player1 = tokens[1];
            String player2 = tokens[2];
            int player1Score = Integer.parseInt(tokens[0]);
            int player2Score = Integer.parseInt(tokens[3]);

            players.putIfAbsent(player1, new Player());
            players.putIfAbsent(player2, new Player());
            players.get(player1).totalScore += (player1Score - player2Score);
            players.get(player1).fights.add(player2 + " <-> " + (player1Score - player2Score));
            players.get(player2).totalScore += (player2Score - player1Score);
            players.get(player2).fights.add(player1 + " <-> " + (player2Score - player1Score));
        }

        players.entrySet().stream().sorted((a, b) -> Long.compare(b.getValue().totalScore, a.getValue().totalScore))
                .forEach(p -> {
                    System.out.printf("%s - (%d)%n", p.getKey(), p.getValue().totalScore);
                    p.getValue().fights.forEach(f -> System.out.println("*   " + f));
                });
    }
}

class Player {
    long totalScore = 0;
    List<String> fights = new ArrayList<>();
}
