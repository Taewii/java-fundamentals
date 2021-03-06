package app.entities.car;

import app.interfaces.car.CarInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerformanceCar extends Car implements CarInterface {

    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower,
                          int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    public void setHorsepower(int horsepower) {
        super.setHorsepower(horsepower + ((horsepower * 50) / 100));
    }

    @Override
    public void setSuspension(int suspension) {
        super.setSuspension(suspension - ((suspension * 25) / 100));
    }

    @Override
    public int getHorsepower() {
        return super.getHorsepower();
    }

    @Override
    public int getSuspension() {
        return super.getSuspension();
    }

    public void addAddOn(String addOn) {
        this.addOns.add(addOn);
    }

    public List<String> getAddOns() {
        return Collections.unmodifiableList(this.addOns);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s %d%n", super.getBrand(), super.getModel(), super.getYearOfProduction()));
        sb.append(String.format("%d HP, 100 m/h in %d s%n", this.getHorsepower(), super.getAcceleration()));
        sb.append(String.format("%d Suspension force, %d Durability%n", this.getSuspension(), super.getDurability()));
        sb.append("Add-ons: ");
        if (this.addOns.size() > 0) {
            sb.append(String.join(", ", this.addOns)).append(System.lineSeparator());
        } else {
            sb.append("None").append(System.lineSeparator());
        }
        return sb.toString();
    }
}
