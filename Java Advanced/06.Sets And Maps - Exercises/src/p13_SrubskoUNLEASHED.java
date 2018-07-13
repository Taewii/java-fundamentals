import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class p13_SrubskoUNLEASHED {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, Map<String, Integer>> concerts = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("^([A-Z-a-z\\s]+) @([A-Z-a-z\\s]+) (\\d+) (\\d+)$");

        String input;
        while (!"End".equals(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String singer = matcher.group(1);
                String venue = matcher.group(2);
                int ticketPrice = Integer.parseInt(matcher.group(3));
                int ticketCount = Integer.parseInt(matcher.group(4));

                concerts.putIfAbsent(venue, new LinkedHashMap<>());
                concerts.get(venue).putIfAbsent(singer, 0);
                concerts.get(venue).put(singer, concerts.get(venue).get(singer) + (ticketPrice * ticketCount));
            }
        }

        StringBuilder result = new StringBuilder();
        concerts.forEach((key, value) -> {
            result.append(key).append(System.lineSeparator());

            value.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .forEach(singer -> result.append("#  ")
                            .append(singer.getKey())
                            .append(" -> ")
                            .append(singer.getValue())
                            .append(System.lineSeparator()));
        });

        System.out.println(result.toString());
    }
}


