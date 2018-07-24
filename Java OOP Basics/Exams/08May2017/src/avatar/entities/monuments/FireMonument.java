package avatar.entities.monuments;

import avatar.contracts.monuments.FireMonumentInterface;

public class FireMonument extends Monument implements FireMonumentInterface {

    private int fireAffinity;

    public FireMonument(String name, int fireAffinity) {
        super(name);
        this.fireAffinity = fireAffinity;
    }

    @Override
    public int getFireAffinity() {
        return this.fireAffinity;
    }

    @Override
    public String toString() {
        return String.format("Fire Monument: %s, Fire Affinity: %d%n", super.getName(), this.fireAffinity);
    }
}
