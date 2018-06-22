import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class p10_GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<Integer, List<String>> students = new HashMap<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String fullName = tokens[0] + " " + tokens[1];
            int group = Integer.parseInt(tokens[2]);

            students.putIfAbsent(group, new ArrayList<>());
            students.get(group).add(fullName);
        }

        students.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey)).forEach(kv -> {
            System.out.printf("%s - %s%n", kv.getKey(), kv.getValue().toString().replaceAll("[\\[\\]]", ""));
        });
    }
}
