import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class p04_GUnit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, Map<String, Set<String>>> tests = new HashMap<>();
        Pattern pattern = Pattern.compile("^([A-Z][A-Za-z0-9]+) \\| ([A-Z][A-Za-z0-9]+) \\| ([A-Z][A-Za-z0-9]+)$");

        String input;
        while (!"It's testing time!".equals(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String className = matcher.group(1);
                String methodName = matcher.group(2);
                String unitName = matcher.group(3);

                if (!tests.containsKey(className)) {
                    Map<String, Set<String>> methods = new TreeMap<>();
                    Set<String> units = new TreeSet<>();
                    units.add(unitName);
                    methods.put(methodName, units);
                    tests.put(className, methods);
                } else {
                    if (!tests.get(className).containsKey(methodName)) {
                        Set<String> units = new TreeSet<>();
                        units.add(unitName);
                        tests.get(className).put(methodName, units);
                    } else {
                        tests.get(className).get(methodName).add(unitName);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        tests.entrySet().stream().sorted((a, b) -> {
            int amountOfTests1 = a.getValue().values().stream().mapToInt(Set::size).sum();
            int amountOfTest2 = b.getValue().values().stream().mapToInt(Set::size).sum();

            int result = Integer.compare(amountOfTest2, amountOfTests1);

            if (result == 0) {
                result = Integer.compare(a.getValue().size(), b.getValue().size());
            }

            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }

            return result;
        }).forEach(a -> {
            sb.append(a.getKey()).append(":").append(System.lineSeparator());
            a.getValue().entrySet().stream()
                    .sorted((u1, u2) -> {
                        int result = Integer.compare(u2.getValue().size(), u1.getValue().size());

                        if (result == 0) {
                            result = u1.getKey().compareTo(u2.getKey());
                        }

                        return result;
                    })
                    .forEach(c -> {
                        sb.append("##").append(c.getKey()).append(System.lineSeparator());
                        c.getValue().stream().sorted(Comparator.comparingInt(String::length).thenComparing(u -> u))
                                .forEach(test -> {
                                    sb.append("####").append(test).append(System.lineSeparator());
                                });
                    });
        });

        System.out.print(sb);
    }
}
