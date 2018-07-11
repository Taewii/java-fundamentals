package p02_vehicles_extension;

public abstract class Vehicle {

    private double fuelQuantity;
    private double litersPerKm;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double litersPerKm, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
        this.tankCapacity = tankCapacity;
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

    public double getTankCapacity() {
        return this.tankCapacity;
    }
}
