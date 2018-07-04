package p03_validation_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<Person> people = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] tokens = reader.readLine().split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            double salary = Double.parseDouble(tokens[3]);

            Person person = null;
            try {
                person = new Person(firstName, lastName, age, salary);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            if (person != null) {
                people.add(person);
            }
        }

        int percentRaise = Integer.parseInt(reader.readLine());
        people.forEach(p -> {
            p.calculateRaise(percentRaise);
            System.out.println(p);
        });
    }
}
