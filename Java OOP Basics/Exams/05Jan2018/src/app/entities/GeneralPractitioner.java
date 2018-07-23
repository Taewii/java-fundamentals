package app.entities;

import app.contracts.colonies.ColonistInterface;

public class GeneralPractitioner extends Medic implements ColonistInterface {

    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int potential = super.getPotential();

        if (super.getAge() > 15) {
            potential += 1;
        }

        if ("caring".equals(super.getSign())) {
            potential += 1;
        } else if ("careless".equals(super.getSign())) {
            potential -= 2;
        }

        return potential;
    }
}
