package p04_shopping_spree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private int money;
    private List<Product> products;

    public Person(String name, int money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public void setName(String name) {
        if (name.isEmpty() || name.contains(" ")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" - ");
        if (this.products.size() == 0) {
            sb.append("Nothing bought  ");
        } else {
            this.products.forEach(a -> sb.append(a.getName()).append(", "));
        }
        return sb.deleteCharAt(sb.length() - 2).toString();
    }
}
