package p02_vehicles_extension;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
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
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if ((getTankCapacity() - getFuelQuantity()) < liters) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", getFuelQuantity());
    }
}
