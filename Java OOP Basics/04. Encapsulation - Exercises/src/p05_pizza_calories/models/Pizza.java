package p05_pizza_calories.models;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private int count;
    private Dough dough;
    private List<Topping> topping;

    public Pizza(String name, int count) {
        setName(name);
        setCount(count);
        topping = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        this.topping.add(topping);
    }

    private void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addDough(Dough dough) {
        setDough(dough);
    }

    public void setName(String name) {
        if (name == null || name.isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setCount(int count) {
        if (count < 0 || count > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.count = count;
    }

    @Override
    public String toString() {
        double totalCaloriesForToppings = this.topping.stream().mapToDouble(Topping::calculateToppingCalories).sum();

        return String.format("%s - %.2f", this.name, this.dough.calculateDoughCalories() + totalCaloriesForToppings);
    }
}
