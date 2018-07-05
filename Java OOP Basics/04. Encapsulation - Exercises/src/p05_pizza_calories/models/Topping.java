package p05_pizza_calories.models;

import java.util.HashMap;
import java.util.Map;

public class Topping {

    private static final Map<String, Double> TOPPINGS = new HashMap<String, Double>() {
        {
            put("Meat", 1.2);
            put("Veggies", 0.8);
            put("Cheese", 1.1);
            put("Sauce", 0.9);
        }
    };

    private String topping;
    private int weight;

    public Topping(String topping, int weight) {
        setTopping(topping);
        setWeight(weight);
    }

    private void setTopping(String topping) {
        if (!TOPPINGS.containsKey(topping)) {
            throw new IllegalArgumentException("Cannot place " + topping + " on top of your pizza.");
        }
        this.topping = topping;
    }

    private void setWeight(int weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(topping + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateToppingCalories() {
        return (2 * weight) * TOPPINGS.get(topping);
    }
}
