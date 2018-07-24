package avatar.entities.benders;

import avatar.contracts.benders.EarthBend;

public class EarthBender extends Bender implements EarthBend {

    private double groundSaturation;

    public EarthBender(String name, int power, double groundSaturation) {
        super(name, power);
        this.groundSaturation = groundSaturation;
    }

    @Override
    public double getGroundSaturation() {
        return this.groundSaturation;
    }

    @Override
    public String toString() {
        return String.format("Earth Bender: %s, Power: %d, Ground Saturation: %.2f%n",
                super.getName(), super.getPower(), this.groundSaturation);
    }
}
