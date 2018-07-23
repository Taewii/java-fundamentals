package app.entities;

import app.contracts.colonies.ColonistInterface;

public abstract class Engineer extends Colonist implements ColonistInterface {
    public Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        int potential = this.getTalent() + 3;
        if (super.getAge() > 30) {
            potential += 2;
        }
        return potential;
    }
}
