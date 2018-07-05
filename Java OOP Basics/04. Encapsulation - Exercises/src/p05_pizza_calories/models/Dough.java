package p05_pizza_calories.models;

import java.util.HashMap;
import java.util.Map;

public class Dough {

    private static final Map<String, Double> FLOUR_TYPE = new HashMap<String, Double>() {
        {
            put("White", 1.5);
            put("Wholegrain", 1.0);
        }
    };

    private static final Map<String, Double> BAKING_TECHNIQUE = new HashMap<String, Double>() {
        {
            put("Crispy", 0.9);
            put("Chewy", 1.1);
            put("Homemade", 1.0);
        }
    };

    private String flour;
    private String technique;
    private int weight;

    public Dough(String flour, String technique, int weight) {
        setFlour(flour);
        setTechnique(technique);
        setWeight(weight);
    }

    private void setFlour(String flour) {
        if (!FLOUR_TYPE.containsKey(flour)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flour = flour;
    }

    private void setTechnique(String technique) {
        if (!BAKING_TECHNIQUE.containsKey(technique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.technique = technique;
    }

    private void setWeight(int weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateDoughCalories() {
        return (2 * this.weight) * FLOUR_TYPE.get(flour) * BAKING_TECHNIQUE.get(technique);
    }
}
