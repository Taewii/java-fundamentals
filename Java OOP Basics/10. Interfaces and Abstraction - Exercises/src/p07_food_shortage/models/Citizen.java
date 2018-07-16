package p07_food_shortage.models;

import p07_food_shortage.contracts.Birthable;
import p07_food_shortage.contracts.Buyer;
import p07_food_shortage.contracts.Identifiable;

public class Citizen implements Identifiable, Birthable, Buyer {

    private String name;
    private int age;
    private String id;
    private String birthday;
    private int food;

    public Citizen(String name, int age, String id, String birthday) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthday = birthday;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthDate() {
        return this.birthday;
    }


    @Override
    public void buyFood() {
        this.food += 10;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
