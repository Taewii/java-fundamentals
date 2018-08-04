package p03_coffee_machine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    private int money;
    private List<Coffee> coffees;

    public CoffeeMachine() {
        this.coffees = new ArrayList<>();
    }

    public void buyCoffee(String size, String type) {
        Coffee coffee = new Coffee(size, type);
        if (this.money >= coffee.getPrice()) {
            this.coffees.add(coffee);
            this.money = 0;
        }
    }

    public void insertCoin(String coin) {
        this.money += Coin.valueOf(coin.toUpperCase()).getValue();
    }

    public Iterable<Coffee> coffeesSold() {
        return this.coffees;
    }
}
