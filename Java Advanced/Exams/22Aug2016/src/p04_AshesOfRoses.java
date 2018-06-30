import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static java.lang.System.in;

public class p04_AshesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, Map<String, Long>> regions = new TreeMap<>();
        Pattern pattern = Pattern.compile("^Grow <([A-Z][a-z]+)> <([A-Za-z0-9]+)> (\\d+)$");

        String input;
        while (!"icarus, ignite!".equalsIgnoreCase(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String region = matcher.group(1);
                String color = matcher.group(2);
                long amount = Long.parseLong(matcher.group(3));

                regions.putIfAbsent(region, new TreeMap<>());
                regions.get(region).putIfAbsent(color, 0L);
                if (regions.get(region).containsKey(color)) {
                    regions.get(region).put(color, regions.get(region).get(color) + amount);
                }
            }
        }

        regions.entrySet().stream().sorted((a, b) -> {
            long aSum = a.getValue().values().stream().mapToLong(Long::valueOf).sum();
            long bSum = b.getValue().values().stream().mapToLong(Long::valueOf).sum();

            return Long.compare(bSum, aSum);
        }).forEach(r -> {
            System.out.println(r.getKey());
            r.getValue().entrySet().stream().sorted(Comparator.comparingLong(Map.Entry::getValue))
                    .forEach(f -> System.out.printf("*--%s | %d%n", f.getKey(), f.getValue()));
        });
    }
}
