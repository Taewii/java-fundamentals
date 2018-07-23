package app.entities.car;

import app.interfaces.car.CarInterface;

public abstract class Car implements CarInterface {

    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        setHorsepower(horsepower);
        this.acceleration = acceleration;
        setSuspension(suspension);
        this.durability = durability;
    }

    @Override
    public void addHorsepowerFromTune(int horsepower) {
        this.horsepower += horsepower;
    }

    @Override
    public void addSuspensionFromTune(int suspension) {
        this.suspension += suspension;
    }

    @Override
    public void removeDurability(int durability) {
        this.durability -= durability;
    }

    @Override
    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getYearOfProduction() {
        return this.yearOfProduction;
    }

    @Override
    public int getHorsepower() {
        return this.horsepower;
    }

    @Override
    public int getAcceleration() {
        return this.acceleration;
    }

    @Override
    public int getSuspension() {
        return this.suspension;
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
