package app.interfaces.car;

public interface CarInterface {

    String getBrand();

    String getModel();

    int getYearOfProduction();

    int getHorsepower();

    int getAcceleration();

    int getSuspension();

    int getDurability();

    void addHorsepowerFromTune(int horsepower);

    void addSuspensionFromTune(int suspension);

    void removeDurability(int durability);

    void setHorsepower(int horsepower);

    void setSuspension(int suspension);
}
