package avatar.entities.benders;

import avatar.contracts.benders.AirBend;

public class AirBender extends Bender implements AirBend {

    private double aerialIntegrity;

    public AirBender(String name, int power, double aerialIntegrity) {
        super(name, power);
        this.aerialIntegrity = aerialIntegrity;

    }

    @Override
    public double getAerialIntegrity() {
        return this.aerialIntegrity;
    }

    @Override
    public String toString() {
        return String.format("Air Bender: %s, Power: %d, Aerial Integrity: %.2f%n",
                super.getName(), super.getPower(), this.aerialIntegrity);
    }
}
