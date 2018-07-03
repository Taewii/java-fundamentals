package p09_google;

import p09_google.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, Person> people = new HashMap<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String name = tokens[0];
            String command = tokens[1];

            Person person = new Person(new Company(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new Car());
            people.putIfAbsent(name, person);

            switch (command) {
                case "company":
                    people.get(name).getCompany().setName(tokens[2]);
                    people.get(name).getCompany().setDepartment(tokens[3]);
                    people.get(name).getCompany().setSalary(Double.parseDouble(tokens[4]));
                    break;
                case "pokemon":
                    people.get(name).getPokemons().add(new Pokemon(tokens[2], tokens[3]));
                    break;
                case "parents":
                    people.get(name).getParents().add(new Parent(tokens[2], tokens[3]));
                    break;
                case "children":
                    people.get(name).getChildren().add(new Child(tokens[2], tokens[3]));
                    break;
                case "car":
                    people.get(name).getCar().setModel(tokens[2]);
                    people.get(name).getCar().setSpeed(Integer.parseInt(tokens[3]));
                    break;
            }
        }

        String outputName = reader.readLine();
        System.out.println(outputName);
        System.out.println(people.get(outputName));
    }
}
