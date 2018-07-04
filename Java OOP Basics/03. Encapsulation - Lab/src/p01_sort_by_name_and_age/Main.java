package p01_sort_by_name_and_age;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
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

            Person person = new Person(firstName, lastName, age);
            people.add(person);
        }

        people.stream()
                .sorted(Comparator.comparing(Person::getFirstName)
                 .thenComparingInt(Person::getAge))
                  .forEach(System.out::println);
    }
}
