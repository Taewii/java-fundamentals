package p10_cat_lady.models;

public class Siamese extends Cat {

    private double earSize;

    public Siamese(String name, String breed, double earSize) {
        super(name, breed);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%.2f", this.earSize);
    }
}
