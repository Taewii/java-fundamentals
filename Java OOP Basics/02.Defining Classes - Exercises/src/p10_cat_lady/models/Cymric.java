package p10_cat_lady.models;

public class Cymric extends Cat {

    private double furLength;

    public Cymric(String name, String breed, double furLength) {
        super(name, breed);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%.2f", this.furLength);
    }
}
