package paw.entities.animal;

import paw.contracts.animal.CatInterface;

public class Cat extends Animal implements CatInterface {

    private int intelligenceCoefficient;

    public Cat(String name, int age, int intelligenceCoefficient) {
        super(name, age);
        this.intelligenceCoefficient = intelligenceCoefficient;
    }

    @Override
    public int getIntelligenceCoefficient() {
        return this.intelligenceCoefficient;
    }
}
