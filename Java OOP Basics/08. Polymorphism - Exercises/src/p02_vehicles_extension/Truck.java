package p02_vehicles_extension;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
    }

    @Override
    public void drive(double km) {
        double fuelNeeded = km * (this.getLitersPerKm() + 1.6);
        if (this.getFuelQuantity() > fuelNeeded) {
            this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
        } else {
            throw new IllegalArgumentException("Truck needs refueling");
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
        this.setFuelQuantity(this.getFuelQuantity() + liters - (liters * 5) / 100);
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", getFuelQuantity());
    }
}
