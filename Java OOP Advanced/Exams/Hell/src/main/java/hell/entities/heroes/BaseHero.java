package hell.entities.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

public abstract class BaseHero implements Hero {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private Inventory inventory;

    protected BaseHero(String name, int strength, int agility, int intelligence,
                       int hitPoints, int damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = new HeroInventory();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Item> getItems() {
        Field[] fields = this.inventory.getClass().getDeclaredFields();
        Collection<Item> items = null;

        for (Field field : fields) {
            if (field.isAnnotationPresent(ItemCollection.class)) {
                field.setAccessible(true);
                try {
                    Map<String, Item> itemsMap = (Map<String, Item>) field.get(this.inventory);
                    items = itemsMap.values();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return items;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Hero: %s, Class: %s%n", this.name, this.getClass().getSimpleName()));
        sb.append(String.format("HitPoints: %d, Damage: %d%n", this.getHitPoints(), this.getDamage()));
        sb.append(String.format("Strength: %d%n", this.getStrength()));
        sb.append(String.format("Agility: %d%n", this.getAgility()));
        sb.append(String.format("Intelligence: %d%n", this.getIntelligence()));
        sb.append("Items:").append(this.getItems().size() == 0 ? " None" : System.lineSeparator());
        this.getItems().forEach(sb::append);

        return sb.toString().trim();
    }
}
