package app.entities;

import app.contracts.colonies.ColonistInterface;

public abstract class Medic extends Colonist implements ColonistInterface {

    private String sign;

    protected Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
    }

    @Override
    public int getPotential() {
        return super.getTalent() + 2;
    }

    protected String getSign() {
        return this.sign;
    }
}
