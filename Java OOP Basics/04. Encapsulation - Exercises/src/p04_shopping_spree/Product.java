package p04_shopping_spree;

public class Product {

    private String name;
    private int cost;

    public Product(String name, int cost) {
       setName(name);
       setCost(cost);
    }

    public void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setCost(int cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    public int getCost() {
        return this.cost;
    }

    public String getName() {
        return this.name;
    }
}
