package app.entities.garage;

import app.Constants;
import app.entities.car.Car;
import app.entities.car.PerformanceCar;
import app.entities.car.ShowCar;
import app.interfaces.garage.GarageInterface;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Garage implements GarageInterface {

    private Map<Integer, Car> parkedCars;

    public Garage() {
        this.parkedCars = new LinkedHashMap<>();
    }

    @Override
    public Map<Integer, Car> getParkedCars() {
        return Collections.unmodifiableMap(this.parkedCars);
    }

    @Override
    public void modify(Car car) {

    }

    public int getSize() {
        return this.parkedCars.size();
    }

    public void park(int id, Car car) {
        car.setParked(true);
        this.parkedCars.put(id, car);
    }

    public void unpark(int id, Car car) {
        car.setParked(false);
        this.parkedCars.remove(id);
    }

    public void tune(int tuneIndex, String addOn) {
        for (Car car : parkedCars.values()) {
            car.addHorsepowerFromTune(tuneIndex);
            car.addSuspensionFromTune((tuneIndex - (tuneIndex * 50) / 100));

            if (Constants.CAR_CLASS_NAME_PERFORMANCE.equals(car.getClass().getSimpleName())) {
                ((PerformanceCar) car).addAddOn(addOn);
            } else if (Constants.CAR_CLASS_NAME_SHOW.equals(car.getClass().getSimpleName())) {
                ((ShowCar) car).addStars(tuneIndex);
            }
        }
    }
}
