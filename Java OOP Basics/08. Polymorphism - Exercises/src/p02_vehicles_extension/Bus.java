package p02_vehicles_extension;

public class Bus extends Vehicle{

    public Bus(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
    }

    @Override
    public void drive(double km) {
        double fuelNeeded = km * (this.getLitersPerKm());
        if (this.getFuelQuantity() > fuelNeeded) {
            this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
        } else {
            throw new IllegalArgumentException("Bus needs refueling");
        }
    }

    public void drive(double km, double fuelPerKm) {
        double fuelNeeded = km * (this.getLitersPerKm() + fuelPerKm);
        if (this.getFuelQuantity() > fuelNeeded) {
            this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
        } else {
            throw new IllegalArgumentException("Bus needs refueling");
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
        return String.format("Bus: %.2f", getFuelQuantity());
    }
}
