package app.entities;

import app.contracts.colonies.ColonistInterface;

public class HardwareEngineer extends Engineer implements ColonistInterface {

    public HardwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        int potential = super.getPotential();
        if (super.getAge() < 18) {
            potential += 2;
        }
        return potential;
    }
}
