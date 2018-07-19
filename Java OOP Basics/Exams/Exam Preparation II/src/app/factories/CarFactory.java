package app.factories;

import app.Constants;
import app.entities.car.Car;
import app.entities.car.PerformanceCar;
import app.entities.car.ShowCar;

public class CarFactory {

    public static Car create(String type, String brand,
                             String model, int yearOfProduction, int horsepower,
                             int acceleration, int suspension, int durability) {
        switch (type) {
            case Constants.CAR_TYPE_PERFORMANCE:
                return new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
            case Constants.CAR_TYPE_SHOW:
                return new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                default: return null;
        }
    }
}
