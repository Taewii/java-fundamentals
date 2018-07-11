package p01_vehicles;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm);
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
        this.setFuelQuantity(this.getFuelQuantity() + liters - (liters * 5) / 100);
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", getFuelQuantity());
    }
}
