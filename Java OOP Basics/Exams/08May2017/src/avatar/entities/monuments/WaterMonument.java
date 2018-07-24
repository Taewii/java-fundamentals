package avatar.entities.monuments;

import avatar.contracts.monuments.WaterMonumentInterface;

public class WaterMonument extends Monument implements WaterMonumentInterface {

    private int waterAffinity;

    public WaterMonument(String name, int waterAffinity) {
        super(name);
        this.waterAffinity = waterAffinity;
    }

    @Override
    public int getWaterAffinity() {
        return this.waterAffinity;
    }

    @Override
    public String toString() {
        return String.format("Water Monument: %s, Water Affinity: %d%n", super.getName(), this.waterAffinity);
    }
}
