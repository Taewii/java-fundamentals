package paw.core;

import paw.contracts.ManagerInterface;
import paw.entities.animal.Animal;
import paw.entities.animal.Cat;
import paw.entities.animal.Dog;
import paw.entities.centers.AdoptionCenter;
import paw.entities.centers.CastrationCenter;
import paw.entities.centers.Center;
import paw.entities.centers.CleansingCenter;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalCenterManager implements ManagerInterface {

    private Map<String, Center> centers;
    private List<String> adoptedAnimals;
    private List<String> cleansedAnimals;
    private List<String> castratedAnimals;

    public AnimalCenterManager() {
        this.centers = new LinkedHashMap<>();
        this.adoptedAnimals = new ArrayList<>();
        this.cleansedAnimals = new ArrayList<>();
        this.castratedAnimals = new ArrayList<>();
    }

    @Override
    public void registerCleansingCenter(String name) {
        this.centers.putIfAbsent(name, new CleansingCenter(name));
    }

    @Override
    public void registerAdoptionCenter(String name) {
        this.centers.putIfAbsent(name, new AdoptionCenter(name));
    }

    @Override
    public void registerCastrationCenter(String name) {
        this.centers.putIfAbsent(name, new CastrationCenter(name));
    }

    @Override
    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        this.centers.get(adoptionCenterName).addAnimal(new Dog(name, age, learnedCommands));
    }

    @Override
    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        this.centers.get(adoptionCenterName).addAnimal(new Cat(name, age, intelligenceCoefficient));
    }

    @Override
    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        List<Animal> animalsForCleaning = this.centers.get(adoptionCenterName).getUncleanedAnimals();
        this.centers.get(cleansingCenterName).addAnimalsForCleaning(animalsForCleaning);
    }

    @Override
    public void sendForCastration(String adoptionCenterName, String castrationCenterName) {
        List<Animal> animalsForCastration = this.centers.get(adoptionCenterName).getUncleanedAnimals();
        this.centers.get(castrationCenterName).addAnimalsForCastration(animalsForCastration);
    }

    @Override
    public void cleanse(String cleansingCenterName) {
        List<String> cleansedAnimalNames = this.centers.get(cleansingCenterName).cleanse();
        this.cleansedAnimals.addAll(cleansedAnimalNames);
    }

    @Override
    public void castrate(String castrationCenterName) {
        List<String> castratedAnimalNames = this.centers.get(castrationCenterName).castrate();
        this.castratedAnimals.addAll(castratedAnimalNames);
    }

    @Override
    public void adopt(String adoptionCenterName) {
        List<String> adoptedAnimalNames = this.centers.get(adoptionCenterName).adopt();
        this.adoptedAnimals.addAll(adoptedAnimalNames);
    }

    @Override
    public String printStatistics() {
        StringBuilder sb = new StringBuilder();

        //comment this to pass the main input/output tests
        //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
        sb.append("Paw Inc. Regular Castration Statistics").append(System.lineSeparator());
        sb.append("Castration Centers: ").append(this.getCastrationCentersCount()).append(System.lineSeparator());
        sb.append("Castrated Animals: ");

        if (this.castratedAnimals.size() == 0) {
            sb.append("None");
        } else {
            sb.append(String.join(", ", this.castratedAnimals.stream()
                    .sorted(Comparator.naturalOrder()).collect(Collectors.toList())));
        }
        sb.append(System.lineSeparator());
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

        sb.append("Paw Incorporative Regular Statistics").append(System.lineSeparator());
        sb.append("Adoption Centers: ").append(this.getAdoptionCentersCount()).append(System.lineSeparator());
        sb.append("Cleansing Centers: ").append(this.getCleansingCentersCount()).append(System.lineSeparator());
        sb.append("Adopted Animals: ");

        if (this.adoptedAnimals.size() == 0) {
            sb.append("None");
        } else {
            sb.append(String.join(", ", this.adoptedAnimals.stream()
                    .sorted(Comparator.naturalOrder()).collect(Collectors.toList())));
        }

        sb.append(System.lineSeparator());
        sb.append("Cleansed Animals: ");

        if (this.cleansedAnimals.size() == 0) {
            sb.append("None");
        } else {
            sb.append(String.join(", ", this.cleansedAnimals.stream()
                    .sorted(Comparator.naturalOrder()).collect(Collectors.toList())));
        }

        sb.append(System.lineSeparator());
        sb.append("Animals Awaiting Adoption: ").append(this.getAnimalsAwaitingAdoptionCount()).append(System.lineSeparator());
        sb.append("Animals Awaiting Cleansing: ").append(this.getAnimalsAwaitingCleansingCount()).append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public int getCastrationCentersCount() {
        int count = 0;
        for (Center center : this.centers.values()) {
            if ("CastrationCenter".equals(center.getClass().getSimpleName())) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getAdoptionCentersCount() {
        int count = 0;
        for (Center center : this.centers.values()) {
            if ("AdoptionCenter".equals(center.getClass().getSimpleName())) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getCleansingCentersCount() {
        int count = 0;
        for (Center center : this.centers.values()) {
            if ("CleansingCenter".equals(center.getClass().getSimpleName())) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getAnimalsAwaitingAdoptionCount() {
        int count = 0;
        for (Center center : this.centers.values()) {
            if ("AdoptionCenter".equals(center.getClass().getSimpleName())) {
                count += center.getAnimalsAwaitingAdoption();
            }
        }
        return count;
    }

    @Override
    public int getAnimalsAwaitingCleansingCount() {
        int count = 0;
        for (Center center : this.centers.values()) {
            if ("CleansingCenter".equals(center.getClass().getSimpleName())) {
                count += center.getAnimalsAwaitingCleansing();
            }
        }
        return count;
    }
}