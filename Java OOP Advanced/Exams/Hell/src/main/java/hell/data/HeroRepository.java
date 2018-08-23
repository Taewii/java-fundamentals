package hell.data;

import hell.interfaces.Hero;
import hell.interfaces.Repository;

import java.util.HashMap;
import java.util.Map;

public class HeroRepository implements Repository {

    private Map<String, Hero> heroes;

    public HeroRepository() {
        this.heroes = new HashMap<>();
    }

    @Override
    public void addHero(Hero hero) {
        this.heroes.put(hero.getName(), hero);
    }

    @Override
    public Hero getHero(String name) {
        return this.heroes.get(name);
    }

    @Override
    public String getStatistics() {
        //TODO
        return null;
    }
}
