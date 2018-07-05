package p03_animal_farm;

import java.text.DecimalFormat;

public class Chicken {

    private String name;
    private int age;
    private double produce;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    public void setName(String name) {
        if (name.isEmpty() || name.charAt(0) == ' ') {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private void calculateProductPerDay(int age) {
        if (this.age <= 5) {
            this.produce = 2;
        } else if (age > 11) {
            this.produce = 0.75;
        } else {
            produce = 1;
        }
    }

    public void productPerDay() {
        calculateProductPerDay(this.age);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("Chicken %s (age %d) can produce %s eggs per day.", this.name, this.age, df.format(this.produce));
    }
}
