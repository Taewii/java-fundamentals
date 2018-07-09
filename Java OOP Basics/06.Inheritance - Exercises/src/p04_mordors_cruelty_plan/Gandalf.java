package p04_mordors_cruelty_plan;

import java.util.HashMap;
import java.util.Map;

public class Gandalf {

    private final Map<String, Integer> FOODS = new HashMap<String, Integer>() {{
        put("cram", 2);
        put("lembas", 3);
        put("apple", 1);
        put("melon", 1);
        put("honeycake", 5);
        put("mushrooms", -10);
    }};

    private String[] food;
    private int happiness;

    public Gandalf(String[] food) {
        this.food = food;
    }

    public int calculateHappiness() {
        for (String s : this.food) {
            if (this.FOODS.containsKey(s)) {
                this.happiness += this.FOODS.get(s);
            } else {
                this.happiness -= 1;
            }
        }

        return this.happiness;
    }

    public String calculateMood() {
        String mood;
        if (this.happiness < -5) {
            mood = "Angry";
        } else if (this.happiness < 1) {
            mood = "Sad";
        } else if (this.happiness < 15) {
            mood = "Happy";
        } else {
            mood = "JavaScript";
        }

        return mood;
    }
}
