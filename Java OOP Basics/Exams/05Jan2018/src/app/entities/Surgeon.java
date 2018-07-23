package app.entities;

import app.contracts.colonies.ColonistInterface;

public class Surgeon extends Medic implements ColonistInterface {

    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int potential = super.getPotential();

        if (super.getAge() > 25 && super.getAge() < 35) {
            potential += 2;
        }

        if ("precise".equals(super.getSign())) {
            potential += 3;
        } else if ("butcher".equals(super.getSign())) {
            potential -= 3;
        }

        return potential;
    }
}
