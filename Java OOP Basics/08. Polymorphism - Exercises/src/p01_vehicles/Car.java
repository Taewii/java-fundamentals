package p01_vehicles;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm);
    }

    @Override
    public void drive(double km) {
        double fuelNeeded = km * (this.getLitersPerKm() + 0.9);
        if (this.getFuelQuantity() > fuelNeeded) {
            this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
        } else {
            throw new IllegalArgumentException("Car needs refueling");
        }
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", getFuelQuantity());
    }
}
