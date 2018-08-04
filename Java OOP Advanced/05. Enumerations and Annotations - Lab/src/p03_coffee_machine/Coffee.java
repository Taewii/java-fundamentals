package p03_coffee_machine;

public class Coffee {

    private CoffeeSize size;
    private CoffeeType type;

    public Coffee(String size, String type) {
        this.size = CoffeeSize.valueOf(size.toUpperCase());
        this.type = CoffeeType.valueOf(type.toUpperCase());
    }

    public int getPrice() {
        return this.size.getPrice();
    }

    @Override
    public String toString() {
        return this.size + " " + this.type;
    }
}
