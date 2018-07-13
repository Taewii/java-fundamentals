import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, List<Dragon>> dragons = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] tokens = reader.readLine().split(" ");
            String type = tokens[0];
            String name = tokens[1];
            String damage = tokens[2];
            String health = tokens[3];
            String armor = tokens[4];

            dragons.putIfAbsent(type, new ArrayList<>());

            if (dragonExists(dragons, type, name)) {
                Optional<Dragon> dragon = dragons.get(type).stream()
                        .filter(drag -> drag.getName().equals(name)).findFirst();
                dragon.get().setDamage(damage);
                dragon.get().setHealth(health);
                dragon.get().setArmor(armor);
            } else {
                Dragon dragon = new Dragon(name, damage, health, armor);
                dragons.get(type).add(dragon);
            }
        }

        StringBuilder result = new StringBuilder();
        dragons.forEach((key, value) -> {
            double avgDamage = value.stream().mapToDouble(Dragon::getDamage).sum() / value.size();
            double avgHealth = value.stream().mapToDouble(Dragon::getHealth).sum() / value.size();
            double avgArmor = value.stream().mapToDouble(Dragon::getArmor).sum() / value.size();

            result.append(String.format("%s::(%.2f/%.2f/%.2f)", key, avgDamage, avgHealth, avgArmor))
                    .append(System.lineSeparator());

            value.stream().sorted(Comparator.comparing(Dragon::getName)).forEach(dragon ->
                    result.append("-")
                    .append(dragon.getName()).append(" -> ")
                    .append("damage: ").append(dragon.getDamage()).append(", ")
                    .append("health: ").append(dragon.getHealth()).append(", ")
                    .append("armor: ").append(dragon.getArmor())
                    .append(System.lineSeparator()));
        });

        System.out.println(result.toString());
    }

    private static boolean dragonExists(Map<String, List<Dragon>> dragons, String type, String name) {
        for (Dragon dragon : dragons.get(type)) {
            if (name.equals(dragon.getName())) {
                return true;
            }
        }
        return false;
    }
}

class Dragon {

    private String name;
    private int damage;
    private int health;
    private int armor;

    public Dragon(String name, String damage, String health, String armor) {
        setName(name);
        setDamage(damage);
        setHealth(health);
        setArmor(armor);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(String damage) {
        if ("null".equals(damage)) {
            this.damage = 45;
        } else {
            this.damage = Integer.parseInt(damage);
        }
    }

    public void setHealth(String health) {
        if ("null".equals(health)) {
            this.health = 250;
        } else {
            this.health = Integer.parseInt(health);
        }
    }

    public void setArmor(String armor) {
        if ("null".equals(armor)) {
            this.armor = 10;
        } else {
            this.armor = Integer.parseInt(armor);
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getHealth() {
        return this.health;
    }

    public int getArmor() {
        return this.armor;
    }
}

