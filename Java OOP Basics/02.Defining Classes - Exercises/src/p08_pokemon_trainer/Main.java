package p08_pokemon_trainer;

import p08_pokemon_trainer.models.Pokemon;
import p08_pokemon_trainer.models.Trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input;
        while (!"Tournament".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String name = tokens[0];
            String pokemon = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Pokemon pokemon1 = new Pokemon(pokemon, element, health);
            Trainer trainer = new Trainer(name, 0, new ArrayList<>());
            trainer.getPokemons().add(pokemon1);

            if (!trainers.containsKey(name)) {
                trainers.put(name, trainer);
            } else {
                trainers.get(name).getPokemons().add(pokemon1);
            }
        }

        while (!"End".equals(input = reader.readLine())) {
            String element = input;
            switch (input) {
                case "Fire":
                    trainers.values().forEach(t -> t.checkPokemons(element));
                    break;
                case "Water":
                    trainers.values().forEach(t -> t.checkPokemons(element));
                    break;
                case "Electricity":
                    trainers.values().forEach(t -> t.checkPokemons(element));
                    break;
            }
        }

        trainers.values().stream().sorted((a, b) -> Integer.compare(b.getBadges(), a.getBadges()))
                .forEach(System.out::println);
    }
}
