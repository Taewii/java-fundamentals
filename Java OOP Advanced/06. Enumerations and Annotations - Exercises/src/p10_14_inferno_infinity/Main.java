package p10_14_inferno_infinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.System.in;

public class Main { // too lazy to do the refactoring, :(
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, Weapon> weapons = new LinkedHashMap<>();
        Class<Weapon> weaponClass = Weapon.class;
        CustomAnnotation annotation = weaponClass.getAnnotation(CustomAnnotation.class);

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(";");

            switch (tokens[0]) {
                case "Create":
                    Weapon weapon = new Weapon(tokens[1], tokens[2]);
                    weapons.put(tokens[2], weapon);
                    break;
                case "Add":
                    weapons.get(tokens[1]).addGem(Integer.parseInt(tokens[2]), tokens[3]);
                    break;
                case "Remove":
                    weapons.get(tokens[1]).removeGem(Integer.parseInt(tokens[2]));
                    break;
                case "Print":
                    System.out.println(weapons.get(tokens[1]));
                    break;
                case "Compare":
                    if (weapons.get(tokens[1]).compareTo(weapons.get(tokens[2])) > 0) {
                        System.out.println(weapons.get(tokens[1]).print());
                    } else if (weapons.get(tokens[1]).compareTo(weapons.get(tokens[2])) < 0) {
                        System.out.println(weapons.get(tokens[2]).print());
                    } else {
                        System.out.println(weapons.get(tokens[1]).print());
                    }
                    break;
                case "Author":
                    System.out.println("Author: " + annotation.author());
                    break;
                case "Revision":
                    System.out.println("Revision: " + annotation.revision());
                    break;
                case "Description":
                    System.out.println("Class description: " + annotation.description());
                    break;
                case "Reviewers":
                    System.out.println("Reviewers: " + String.join(", ", annotation.reviewers()));
                    break;
            }
        }
    }
}
