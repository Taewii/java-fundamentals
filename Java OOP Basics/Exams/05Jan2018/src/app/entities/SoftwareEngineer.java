package app.entities;

import app.contracts.colonies.ColonistInterface;

public class SoftwareEngineer extends Engineer implements ColonistInterface {

    public SoftwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        return super.getPotential() + 2;
    }
}
