import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class p04_FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<String> games = new ArrayList<>();

        String input; // no idea how this code doesn't exceed time limits lol
        while (!"Season End".equals(input = reader.readLine())) {
            String[] tokens = input.split("[\\s-:]+");
            String home = tokens[0];
            String guest = tokens[1];
            String homeScore = tokens[3];
            String guestScore = tokens[4];

            games.add(home + " - " + guest + " -> " + homeScore + ":" + guestScore);
            games.add(guest + " - " + home + " -> " + guestScore + ":" + homeScore);
        }

        String[] teamNames = reader.readLine().split(", ");
        for (String team : teamNames) {
            games.stream().filter(x-> x.split(" - ")[0].equals(team))
                    .sorted(Comparator.comparing(a -> a.split("[\\s-:]+")[1])).forEach(System.out::println);
        }
    }
}
