package p01_vehicles;

public abstract class Vehicle {

    private double fuelQuantity;
    private double litersPerKm;

    public Vehicle(double fuelQuantity, double litersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
    }

    public abstract void drive(double km);

    public abstract void refuel(double liters);

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getLitersPerKm() {
        return this.litersPerKm;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }
}
