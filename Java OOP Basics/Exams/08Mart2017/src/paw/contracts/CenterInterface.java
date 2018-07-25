package paw.contracts;

import paw.entities.animal.Animal;

import java.util.List;

public interface CenterInterface {

    String getName();

    List<Animal> getAnimals();

    void addAnimal(Animal animal);

    List<Animal> getUncleanedAnimals();

    void addAnimalsForCleaning(List<Animal> animalsForCleaning);

    List<String> adopt();

    void addAnimalsForCastration(List<Animal> animalsForCastration);

    List<String> castrate();

    List<String> cleanse();

    int getAnimalsAwaitingAdoption();

    int getAnimalsAwaitingCleansing();
}
