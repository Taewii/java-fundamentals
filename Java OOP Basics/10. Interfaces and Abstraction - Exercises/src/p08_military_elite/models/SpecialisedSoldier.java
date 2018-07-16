package p08_military_elite.models;


import p08_military_elite.contracts.SpecialisedSoldierInterface;

public abstract class SpecialisedSoldier extends Private implements SpecialisedSoldierInterface {

    private static final String AIR_FORCE_CORP_TYPE = "Airforces";
    private static final String MARINES_CORP_TYPE = "Marines";

    private String corp;

    protected SpecialisedSoldier(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary);
        setCorp(corp);
    }

    @Override
    public void setCorp(String corp) {
        if (!corp.equals(AIR_FORCE_CORP_TYPE) && !corp.equals(MARINES_CORP_TYPE)) {
            throw new IllegalArgumentException();
        }
        this.corp = corp;
    }

    @Override
    public String getCorp() {
        return this.corp;
    }
}
