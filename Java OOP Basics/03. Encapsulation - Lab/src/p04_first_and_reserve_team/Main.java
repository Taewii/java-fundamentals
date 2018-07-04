package p04_first_and_reserve_team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(reader.readLine());
        Team team = new Team("CHERVEN TRAKTOR BINKOS!!! OLE OLE");

        while (n-- > 0) {
            String[] tokens = reader.readLine().split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            double salary = Double.parseDouble(tokens[3]);

            Person person = new Person(firstName, lastName, age, salary);
            team.addPlayer(person);
        }

        System.out.println(team);
    }
}
