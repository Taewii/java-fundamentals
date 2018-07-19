package app.entities.garage;

import app.entities.car.Car;
import app.interfaces.garage.GarageInterface;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Garage implements GarageInterface {

    private Map<Integer, Car> parkedCars;

    public Garage() {
        this.parkedCars = new HashMap<>();
    }

    @Override
    public Map<Integer, Car> getParkedCars() {
        return Collections.unmodifiableMap(this.parkedCars);
    }

    @Override
    public void modify(Car car) {

    }
}
