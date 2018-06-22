import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class p03_StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<String> people = new ArrayList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String firstName = tokens[0];
            String secondName = tokens[1];
            int age = Integer.parseInt(tokens[2]);

            if (age >= 18 && age <= 24) {
                people.add(firstName + " " + secondName + " " + age);
            }
        }

        people.forEach(System.out::println);
    }
}
