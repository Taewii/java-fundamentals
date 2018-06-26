import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.in;

public class p04_Ranking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, String> courseAndPassword = new HashMap<>();
        Map<String, Map<String, Integer>> rankings = new TreeMap<>();

        String input;
        while (!"end of contests".equals(input = reader.readLine())) {
            String[] tokens = input.split(":");
            courseAndPassword.put(tokens[0], tokens[1]);
        }

        while (!"end of submissions".equals(input = reader.readLine())) {
            String[] tokens = input.split("=>");
            String course = tokens[0];
            String password = tokens[1];
            String name = tokens[2];
            int points = Integer.parseInt(tokens[3]);

            if (courseAndPassword.containsKey(course) && courseAndPassword.get(course).equals(password)) {
                Map<String, Integer> current = new HashMap<>();

                if (!rankings.containsKey(name)) {
                    current.put(course, points);
                    rankings.put(name, current);
                } else {
                    if (rankings.get(name).containsKey(course)) {
                        if (rankings.get(name).get(course) < points) {
                            rankings.get(name).put(course, points);
                        }
                    } else {
                        rankings.get(name).put(course, points);
                    }
                }
            }
        }

        rankings.entrySet().stream().sorted((a, b) -> {
            int sum1 = a.getValue().values().stream().mapToInt(Integer::valueOf).sum();
            int sum2 = b.getValue().values().stream().mapToInt(Integer::valueOf).sum();

            return Integer.compare(sum2, sum1);
        }).limit(1).forEach(a -> System.out.printf("Best candidate is %s with total %d points.%n",
                a.getKey(), a.getValue().values().stream().mapToInt(Integer::valueOf).sum()));

        System.out.println("Ranking:");
        rankings.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .forEach(r -> System.out.printf("#  %s -> %d%n", r.getKey(), r.getValue()));
        });
    }
}
