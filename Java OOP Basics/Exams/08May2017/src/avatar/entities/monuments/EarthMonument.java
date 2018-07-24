package avatar.entities.monuments;

import avatar.contracts.monuments.EarthMonumentInterface;

public class EarthMonument extends Monument implements EarthMonumentInterface {

    private int earthAffinity;

    public EarthMonument(String name, int earthAffinity) {
        super(name);
        this.earthAffinity = earthAffinity;
    }

    @Override
    public int getEarthAffinity() {
        return this.earthAffinity;
    }

    @Override
    public String toString() {
        return String.format("Earth Monument: %s, Earth Affinity: %d%n", super.getName(), this.earthAffinity);
    }
}
