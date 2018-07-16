package p06_birthday_celebrations.models;

import p06_birthday_celebrations.contracts.Birthable;
import p06_birthday_celebrations.contracts.Identifiable;

public class Citizen implements Identifiable, Birthable {

    private String name;
    private int age;
    private String id;
    private String birthday;

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
}
