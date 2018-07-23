package app.interfaces.engine;

import app.entities.car.Car;
import app.entities.race.Race;

import java.util.Map;

public interface Manager {

    void register(int id, String type, String brand, String model,
                  int yearOfProduction, int horsepower, int acceleration,
                  int suspension, int durability);

    String check(int id);

    void open(int id, String type, int length, String route, int prizePool, int extra);

    void open(int id, String type, int length, String route, int prizePool);

    void participate(int carId, int raceId);

    String start(int id);

    void park(int id);

    void unpark(int id);

    void tune(int tuneIndex, String addOn);

    String calculateCircuitRace(int id);

    String calculateTimeLimitRace(int id);

    String calculateDriftRace(int id);

    String calculateDragRace(int id);

    String calculateCasualRace(int id);

    void printPlacings(Map<Integer, Car> result, Race race, int count, int percent, StringBuilder sb);

    boolean isCarInARace(int id);

    boolean isCarParked(int id);
}
