package paw.contracts.animal;

public interface AnimalInterface {

    String getName();

    int getAge();

    boolean getCleaningStatus();

    boolean getCastrationStatus();

    void cleanseAnimal();

    boolean isInACleansingCenter();

    void castrateAnimal();

    void setInACleansingCenter();

    void removeFromTheCleansingCenter();
}
