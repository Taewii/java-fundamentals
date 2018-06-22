import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.in;
import static java.lang.System.out;

public class p01_StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<String> people = new ArrayList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String names = tokens[0] + " " + tokens[1];
            int group = Integer.parseInt(tokens[2]);

            if (group == 2) {
                people.add(names);
            }
        }

        people.stream().sorted(Comparator.comparing(a -> a.split(" ")[0])).forEach(System.out::println);
    }
}
