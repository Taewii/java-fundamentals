package app.interfaces.garage;

import app.entities.car.Car;

import java.util.Map;

public interface GarageInterface {

    Map<Integer, Car> getParkedCars();

    void modify(Car car);
}
