package p03_wild_farm;

import p03_wild_farm.animal_models.*;
import p03_wild_farm.food_models.Food;
import p03_wild_farm.food_models.Meat;
import p03_wild_farm.food_models.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<Animal> animals = new ArrayList<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] animalTokens = input.split(" ");
            String[] foodTokens = reader.readLine().split(" ");

            String animalType = animalTokens[0];
            String animalName = animalTokens[1];
            Double animalWeight = Double.parseDouble(animalTokens[2]);
            String animalLivingRegion = animalTokens[3];

            String foodType = foodTokens[0];
            int quantity = Integer.parseInt(foodTokens[1]);

            Food food;
            if (foodType.equals("Meat")) {
                food = new Meat(quantity);
            } else {
                food = new Vegetable(quantity);
            }

            Animal animal = null;

            switch (animalType) {
                case "Cat":
                    animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, animalTokens[4]);
                    break;
                case "Tiger":
                    animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                    break;
                case "Mouse":
                    animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                    break;
            }

            if (animal != null) {
                try {
                    System.out.println(animal.makeSound());
                    animal.eatFood(food);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
                animals.add(animal);
            }
        }
        animals.forEach(System.out::println);
    }
}
