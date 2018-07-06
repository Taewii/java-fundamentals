package p04_fragile_base_class;

import java.util.ArrayList;
import java.util.List;

public class Animal {

    protected List<Food> foodEaten;

    public Animal() {
        foodEaten = new ArrayList<>();
    }

    public final void eat(Food food) {
        this.foodEaten.add(food);
    }

    public void eatAll(Food[] food) {
        for (Food food1 : food) {
            eat(food1);
        }
    }
}
