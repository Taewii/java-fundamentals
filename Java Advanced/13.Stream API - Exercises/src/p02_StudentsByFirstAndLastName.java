import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class p02_StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<String> people = new ArrayList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String firstName = tokens[0];
            String secondName = tokens[1];

            if (firstName.compareTo(secondName) < 0) {
                people.add(firstName + " " + secondName);
            }
        }

        people.forEach(System.out::println);
    }
}
