package p03_wild_farm.animal_models;

import p03_wild_farm.food_models.Food;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private String livingRegion;

    protected Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.setLivingRegion(livingRegion);
    }

    protected final String getLivingRegion() {
        return this.livingRegion;
    }

    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public void eatFood(Food food) {
        super.addFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                new DecimalFormat("#.##").format(super.getAnimalWeight()),
                this.livingRegion,
                super.getFoodEaten());
    }
}