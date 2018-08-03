package p05_comparing_objects;

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

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            people.add(person);
        }

        int equalPeople = 0;
        int n = Integer.parseInt(reader.readLine());
        Person mainPerson = people.get(n - 1);

        for (Person person : people) {
            if (mainPerson.compareTo(person) == 0) {
                equalPeople++;
            }
        }

        System.out.println(equalPeople == 1 ? "No matches" : String.format("%d %d %d", equalPeople, people.size() - equalPeople, people.size()));
    }
}
