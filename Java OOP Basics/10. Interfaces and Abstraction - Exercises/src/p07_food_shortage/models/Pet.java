package p07_food_shortage.models;

import p07_food_shortage.contracts.Birthable;

public class Pet implements Birthable {

    private String name;
    private String birthday;

    public Pet(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String getBirthDate() {
        return this.birthday;
    }
}
