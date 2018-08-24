package hell.data;

import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Repository;

import java.util.*;

public class HeroRepository implements Repository {

    private Map<String, Hero> heroes;

    public HeroRepository() {
        this.heroes = new LinkedHashMap<>();
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
        StringBuilder sb = new StringBuilder();

        final int[] count = {1};

        this.heroes.values().stream().sorted((a, b) -> {
            long strAgiIntStats1 = a.getAgility() + a.getStrength() + a.getIntelligence();
            long strAgiIntStats2 = b.getAgility() + b.getStrength() + b.getIntelligence();

            long hitDmgStats1 = a.getHitPoints() + a.getDamage();
            long hitDmgStats2 = b.getHitPoints() + b.getDamage();

            int result = Long.compare(strAgiIntStats2, strAgiIntStats1);

            if (result == 0) {
                result = Long.compare(hitDmgStats2, hitDmgStats1);
            }

            return result;
        }).forEach(hero -> {
            List<String> itemNames = new ArrayList<>();
            for (Item item : hero.getItems()) {
                itemNames.add(item.getName());
            }
            sb.append(count[0]++).append(". ");
            sb.append(String.format("%s: %s%n", hero.getClass().getSimpleName(), hero.getName()));
            sb.append(String.format("###HitPoints: %d%n", hero.getHitPoints()));
            sb.append(String.format("###Damage: %d%n", hero.getDamage()));
            sb.append(String.format("###Strength: %d%n", hero.getStrength()));
            sb.append(String.format("###Agility: %d%n", hero.getAgility()));
            sb.append(String.format("###Intelligence: %d%n", hero.getIntelligence()));
            sb.append(String.format("###Items: %s%n", itemNames.size() == 0 ? "None" : String.join(", ", itemNames)));
        });

        return sb.toString().trim();
    }
}
