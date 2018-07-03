package p10_cat_lady.models;

public class StreetExtraordinaire extends Cat {

    private double decibels;

    public StreetExtraordinaire(String name, String breed, double decibels) {
        super(name, breed);
        this.decibels = decibels;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%.2f", this.decibels);
    }
}
