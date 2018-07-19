package app.entities.car;

import app.interfaces.car.CarInterface;

public class ShowCar extends Car implements CarInterface {

    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }

    public void addStars(int stars) {
        this.stars += stars;
    }

    public int getStars() {
        return this.stars;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s %d%n", super.getBrand(), super.getModel(), super.getYearOfProduction()));
        sb.append(String.format("%d HP, 100 m/h in %d s%n", super.getHorsepower(), super.getAcceleration()));
        sb.append(String.format("%d Suspension force, %d Durability%n", super.getSuspension(), super.getDurability()));
        sb.append(String.format("%d *%n", this.getStars()));
        return sb.toString();
    }
}
