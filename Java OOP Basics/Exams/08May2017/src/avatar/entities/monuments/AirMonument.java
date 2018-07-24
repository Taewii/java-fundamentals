package avatar.entities.monuments;

import avatar.contracts.monuments.AirMonumentInterface;

public class AirMonument extends Monument implements AirMonumentInterface {

    private int airAffinity;

    public AirMonument(String name, int airAffinity) {
        super(name);
        this.airAffinity = airAffinity;
    }

    @Override
    public int getAirAffinity() {
        return this.airAffinity;
    }

    @Override
    public String toString() {
        return String.format("Air Monument: %s, Air Affinity: %d%n", super.getName(), this.airAffinity);
    }
}
