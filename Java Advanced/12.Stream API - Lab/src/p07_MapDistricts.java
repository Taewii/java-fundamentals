import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class p07_MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, List<Integer>> cities = new HashMap<>();
        addCitiesToMap(reader, cities);
        int minimum = Integer.parseInt(reader.readLine());

        cities.entrySet()
                .stream()
                .filter(kv -> kv.getValue().stream().reduce((x, y) -> x + y).get() > minimum)
                .sorted((c1, c2) -> {
                    int a = c1.getValue().stream().reduce((x, y) -> x + y).get();
                    int b = c2.getValue().stream().reduce((x, y) -> x + y).get();

                    return Integer.compare(b, a);
                }).forEach(kv -> {
            System.out.print(kv.getKey() + ": ");
            kv.getValue().stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(5)
                    .forEach(p -> System.out.print(p + " "));
            System.out.println();
        });

    }

    private static void addCitiesToMap(BufferedReader reader, Map<String, List<Integer>> cities) throws IOException {
        String[] input = reader.readLine().split(" ");
        for (String str : input) {
            String[] tokens = str.split(":");
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1]);

            cities.putIfAbsent(city, new ArrayList<>());
            cities.get(city).add(population);
        }
    }
}
