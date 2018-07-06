package p04_fragile_base_class;

public class Predator extends Animal{

    private int health;

    public void feed(Food food) {
        this.health++;
        super.eat(food);
    }
}
