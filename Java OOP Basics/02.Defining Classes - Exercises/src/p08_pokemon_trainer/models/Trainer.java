package p08_pokemon_trainer.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {

    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name, int badges, List<Pokemon> pokemons) {
        this.name = name;
        this.badges = badges;
        this.pokemons = pokemons;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public int getBadges() {
        return this.badges;
    }

    public void checkPokemons(String element) {
        boolean hasElement = false;
        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getElement().equals(element)) {
                this.badges += 1;
                hasElement = true;
                break;
            }
        }

        if (!hasElement) {
            for (Pokemon pokemon : this.pokemons) {
                pokemon.setHealth(pokemon.getHealth() - 10);
            }

            this.pokemons = this.pokemons.stream().filter(p -> p.getHealth() > 0).collect(Collectors.toCollection(ArrayList::new));
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.pokemons.size());
    }
}
