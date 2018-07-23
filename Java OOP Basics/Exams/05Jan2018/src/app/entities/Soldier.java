package app.entities;

import app.contracts.colonies.ColonistInterface;

public class Soldier extends Colonist implements ColonistInterface {

    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        return super.getTalent() + 6;
    }
}
