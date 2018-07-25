package paw.entities.animal;

import paw.contracts.animal.AnimalInterface;

public abstract class Animal implements AnimalInterface {

    private String name;
    private int age;
    private boolean cleaningStatus;
    private boolean castrationStatus;
    private boolean isInACleansingCenter;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.cleaningStatus = false;
        this.castrationStatus = false;
        this.isInACleansingCenter = false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public boolean getCleaningStatus() {
        return this.cleaningStatus;
    }

    @Override
    public boolean getCastrationStatus() {
        return this.castrationStatus;
    }

    @Override
    public void cleanseAnimal() {
        this.cleaningStatus = true;
    }

    @Override
    public void castrateAnimal() {
        this.castrationStatus = true;
    }

    @Override
    public boolean isInACleansingCenter() {
        return this.isInACleansingCenter;
    }

    @Override
    public void setInACleansingCenter() {
        this.isInACleansingCenter = true;
    }

    @Override
    public void removeFromTheCleansingCenter() {
        this.isInACleansingCenter = false;
    }
}
