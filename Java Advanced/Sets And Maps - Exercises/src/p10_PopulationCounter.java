import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.System.in;

public class p10_PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, LinkedHashMap<String, Long>> report = new LinkedHashMap<>();

        String input;
        while (!"report".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\|");
            String country = tokens[1];
            String city = tokens[0];
            long population = Long.parseLong(tokens[2]);

            if (!report.containsKey(country)) {
                report.put(country, new LinkedHashMap<>());
            }
            report.get(country).put(city, population);
        }
//                       vvvvv this works but doesn't sort vvvvv
//        for (Map.Entry<String, LinkedHashMap<String, Long>> country : report.entrySet()) {
//            long totalPopulation = 0;
//            for (Long population : report.get(country.getKey()).values()) {
//                totalPopulation += population;
//            }
//            System.out.printf("%s (total population: %d)%n", country.getKey(), totalPopulation);
//            for (Map.Entry<String,Long> city : report.get(country.getKey()).entrySet()) {
//                System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
//            }
//        }

          // I didn't do this
        report.entrySet()
                .stream()
                .sorted((c1, c2) -> Long.compare(c2.getValue() //Countries should be ordered by their total population in descending order, so we sum all cities population
                                .values()
                                .stream()
                                .mapToLong(Long::longValue)
                                .sum(),
                        c1.getValue()
                                .values()
                                .stream()
                                .mapToLong(Long::longValue)
                                .sum()))
                .forEach(c -> {
                    System.out.printf("%s (total population: %d)%n",
                            c.getKey(),
                            c.getValue()
                                    .values()
                                    .stream()
                                    .mapToLong(Long::longValue)
                                    .sum());

                    c.getValue()
                            .entrySet()
                            .stream()
                            .sorted((t1, t2) -> Long.compare(t2.getValue(), t1.getValue())) //the cities should be ordered by the same criterion
                            .forEach(t -> System.out.printf("=>%s: %d%n", t.getKey(), t.getValue()));
                });
    }
}
