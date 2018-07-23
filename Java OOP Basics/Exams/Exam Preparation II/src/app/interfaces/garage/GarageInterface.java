package app.interfaces.garage;

import app.entities.car.Car;

import java.util.Map;

public interface GarageInterface {

    Map<Integer, Car> getParkedCars();

    void modify(Car car);

    int getSize();

    void park(int id, Car car);

    void unpark(int id, Car car);

    void tune(int tuneIndex, String addOn);
}
