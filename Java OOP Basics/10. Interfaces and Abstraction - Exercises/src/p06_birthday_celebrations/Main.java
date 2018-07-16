package p06_birthday_celebrations;

import p06_birthday_celebrations.contracts.Birthable;
import p06_birthday_celebrations.contracts.Identifiable;
import p06_birthday_celebrations.models.Citizen;
import p06_birthday_celebrations.models.Pet;
import p06_birthday_celebrations.models.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<Identifiable> identifiables = new ArrayList<>();
        List<Birthable> birthables = new ArrayList<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Citizen":
                    identifiables.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
                    birthables.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
                    break;
                case "Pet":
                    birthables.add(new Pet(tokens[1], tokens[2]));
                    break;
                case "Robot":
                    identifiables.add(new Robot(tokens[0], tokens[1]));
                    break;
            }
        }

        String controlYear = reader.readLine();

        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(controlYear)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
