package app.engine;

import app.interfaces.engine.Manager;

public class CarManager implements Manager {


    public  CarManager() {
    }

    @Override
    public void register(int id, String type, String brand,
                         String model, int yearOfProduction, int horsepower,
                         int acceleration, int suspension, int durability) {

    }

    @Override
    public String check(int id) {
        return null;
    }

    @Override
    public void open(int id, String type, int length, String route, int prizePool) {

    }

    @Override
    public void participate(int id) {

    }

    @Override
    public String start(int id) {
        return null;
    }

    @Override
    public void park(int id) {

    }

    @Override
    public void unpark(int id) {

    }

    @Override
    public void tune(int tuneIndex, String addOn) {

    }
}
