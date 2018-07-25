package paw.entities.centers;

import paw.contracts.CenterInterface;
import paw.entities.animal.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class Center implements CenterInterface {

    private String name;
    private List<Animal> animals;

    public Center(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(this.animals);
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public List<Animal> getUncleanedAnimals() {
        List<Animal> uncleanerAnimals = new ArrayList<>();

        for (Animal animal : this.animals) {
            if (!animal.getCleaningStatus()) {
                uncleanerAnimals.add(animal);
            }
        }

        return uncleanerAnimals;
    }

    @Override
    public void addAnimalsForCleaning(List<Animal> animalsForCleaning) {
        for (Animal animal : animalsForCleaning) {
            if (!animal.isInACleansingCenter()) {
                this.animals.add(animal);
                animal.setInACleansingCenter();
            }
        }
    }

    @Override
    public void addAnimalsForCastration(List<Animal> animalsForCastration) {
        for (Animal animal : animalsForCastration) {
            if (!animal.isInACleansingCenter()) {
                this.animals.add(animal);
                animal.setInACleansingCenter();
            }
        }
    }

    @Override
    public List<String> castrate() {
        List<String> castratedNames = new ArrayList<>();
        for (Animal animal : this.animals) {
            animal.castrateAnimal();
            animal.removeFromTheCleansingCenter();
            castratedNames.add(animal.getName());
        }
        this.animals.clear();
        return castratedNames;
    }

    @Override
    public List<String> cleanse() {
        List<String> cleansedNames = new ArrayList<>();
        for (Animal animal : this.animals) {
            animal.cleanseAnimal();
            animal.removeFromTheCleansingCenter();
            cleansedNames.add(animal.getName());
        }
        this.animals.clear();
        return cleansedNames;
    }

    @Override
    public List<String> adopt() {
        List<String> adoptedNames = new ArrayList<>();

        Iterator<Animal> animals = this.animals.iterator();
        while (animals.hasNext()) {
            Animal animal = animals.next();
            if (animal.getCleaningStatus()) {
                adoptedNames.add(animal.getName());
                animals.remove();
            }
        }

        return adoptedNames;
    }

    @Override
    public int getAnimalsAwaitingAdoption() {
        int count = 0;
        for (Animal animal : this.animals) {
            if (animal.getCleaningStatus()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getAnimalsAwaitingCleansing() {
        int count = 0;
        for (Animal animal : this.animals) {
            if (!animal.getCleaningStatus()) {
                count++;
            }
        }
        return count;
    }
}
