package p05_speed_racing;

public class Car {

    private String model;
    private double fuel;
    private double fuelCost;
    private int distanceTraveled;

    public Car(String model, int fuel, double fuelCost) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCost = fuelCost;
    }

    public void Drive(double amountOfKm) {
        double fuelNeeded = this.fuelCost * amountOfKm;
        if (fuelNeeded <= this.fuel) {
            this.fuel -= fuelNeeded;
            this.distanceTraveled += amountOfKm;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuel, this.distanceTraveled);
    }
}
