package p08_pet_clinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, Clinic> clinics = new LinkedHashMap<>();
        Map<String, Pet> pets = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] tokens = reader.readLine().split(" ");

            switch (tokens[0]) {
                case "Create":
                    if ("Pet".equals(tokens[1])) {
                        pets.put(tokens[2], new Pet(tokens[2], Integer.parseInt(tokens[3]), tokens[4]));
                    } else {
                        try {
                            clinics.put(tokens[2], new Clinic(Integer.parseInt(tokens[3])));
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;
                case "Add":
                    try {
                        System.out.println(clinics.get(tokens[2]).addPet(pets, tokens[1]));
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Release":
                    System.out.println(clinics.get(tokens[1]).release());
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(tokens[1]).hasEmptyRooms());
                    break;
                case "Print":
                    if (tokens.length == 3) {
                        System.out.println(clinics.get(tokens[1]).print(Integer.parseInt(tokens[2])));
                        //clinics.get(tokens[1]).print(Integer.parseInt(tokens[2]));
                    } else {
                        System.out.println(clinics.get(tokens[1]).print());
                        //clinics.get(tokens[1]).print();
                    }
                    break;
            }
        }
    }
}
