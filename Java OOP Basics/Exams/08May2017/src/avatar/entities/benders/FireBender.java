package avatar.entities.benders;

import avatar.contracts.benders.FireBend;

public class FireBender extends Bender implements FireBend {

    private double heatAggression;

    public FireBender(String name, int power, double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
    }

    @Override
    public double getHeatAggression() {
        return this.heatAggression;
    }

    @Override
    public String toString() {
        return String.format("Fire Bender: %s, Power: %d, Heat Aggression: %.2f%n",
                super.getName(), super.getPower(), this.heatAggression);
    }
}
