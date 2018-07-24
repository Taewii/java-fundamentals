package avatar.entities.benders;

import avatar.contracts.benders.WaterBend;

public class WaterBender extends Bender implements WaterBend {

    private double waterClarity;

    public WaterBender(String name, int power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
    }

    @Override
    public double getWaterClarity() {
        return this.waterClarity;
    }

    @Override
    public String toString() {
        return String.format("Water Bender: %s, Power: %d, Water Clarity: %.2f%n",
                super.getName(), super.getPower(), this.waterClarity);
    }
}
