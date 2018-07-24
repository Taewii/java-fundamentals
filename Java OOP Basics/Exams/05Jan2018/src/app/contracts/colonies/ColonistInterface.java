package app.contracts.colonies;

public interface ColonistInterface {

    int getPotential();

    String getId();

    String getFamilyId();

    int getTalent();

    int getAge();

    void grow(int years);
}
