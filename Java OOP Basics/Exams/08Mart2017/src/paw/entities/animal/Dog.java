package paw.entities.animal;

import paw.contracts.animal.DogInterface;

public class Dog extends Animal implements DogInterface {

    private int amountOfCommands;

    public Dog(String name, int age, int amountOfCommands) {
        super(name, age);
        this.amountOfCommands = amountOfCommands;
    }

    @Override
    public int getAmountOfCommands() {
        return this.amountOfCommands;
    }
}
