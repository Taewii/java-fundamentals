package app.engine;

import app.entities.garage.Garage;
import app.entities.race.Race;
import app.factories.CarFactory;
import app.entities.car.Car;
import app.factories.RaceFactory;
import app.interfaces.engine.Manager;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarManager implements Manager {

    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public  CarManager() {
        this.cars = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
        this.garage = new Garage();
    }

    @Override
    public void register(int id, String type, String brand,
                         String model, int yearOfProduction, int horsepower,
                         int acceleration, int suspension, int durability) {
        Car car = CarFactory.create(type, brand, model, yearOfProduction,
                horsepower, acceleration, suspension, durability);

        if (car != null) {
            this.cars.put(id, car);
        }
    }

    @Override
    public String check(int id) {
        return this.cars.get(id).toString();
    }

    @Override
    public void open(int id, String type, int length, String route, int prizePool) {
        Race race = RaceFactory.create(type, length, route, prizePool);

        if (race != null) {
            this.races.put(id, race);
        }
    }

    @Override
    public void participate(int carId, int raceId) {
        if (!this.cars.get(carId).isParked()) {
            this.cars.get(carId).setParticipatesInARace(true);
            this.races.get(raceId).addParticipant(this.cars.get(carId));
        }
    }

    @Override
    public String start(int id) {
       if (this.races.get(id).getSize() > 0) {
            switch (this.races.get(id).getClass().getSimpleName()) {
                case "CasualRace":
                    return calculateCasualRace(id);
                case "DragRace":
                    return calculateDragRace(id);
                case "DriftRace":
                    return calculateDriftRace(id);
            }
       } else {
           return String.format("Cannot start the race with zero participants.%n");
       }
       return null;
    }

    private String calculateDriftRace(int id) {
        Map<Integer, Car> performances = new LinkedHashMap<>();
        Map<Integer, Car> result = new LinkedHashMap<>();
        Race race = this.races.get(id);
        int count = 1;
        int percent = 0;
        for (Car car : race.getParticipants()) {
            int performance = car.getSuspension() + car.getDurability();
            performances.put(performance, car);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(race.getRoute()).append(" - ").append(race.getLength()).append(System.lineSeparator());
        performances.entrySet().stream().sorted((a, b) -> Integer.compare(b.getKey(), a.getKey())).limit(3)
                .forEach(c -> result.put(c.getKey(), c.getValue()));

        printPlacings(result, race, count, percent, sb);
        this.races.remove(id);
        return sb.toString();
    }

    private String calculateDragRace(int id) {
        Map<Integer, Car> performances = new LinkedHashMap<>();
        Map<Integer, Car> result = new LinkedHashMap<>();
        Race race = this.races.get(id);
        int count = 1;
        int percent = 0;
        for (Car car : race.getParticipants()) {
            int performance = car.getHorsepower() / car.getAcceleration();
            performances.put(performance, car);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(race.getRoute()).append(" - ").append(race.getLength()).append(System.lineSeparator());
        performances.entrySet().stream().sorted((a, b) -> Integer.compare(b.getKey(), a.getKey())).limit(3)
                .forEach(c -> result.put(c.getKey(), c.getValue()));

        printPlacings(result, race, count, percent, sb);
        this.races.remove(id);
        return sb.toString();
    }

    private String calculateCasualRace(int id) {
        Map<Integer, Car> performances = new LinkedHashMap<>();
        Map<Integer, Car> result = new LinkedHashMap<>();
        Race race = this.races.get(id);
        int count = 1;
        int percent = 0;
        for (Car car : race.getParticipants()) {
            int performance = (car.getHorsepower() / car.getAcceleration()) + (car.getSuspension() + car.getDurability());
            performances.put(performance, car);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(race.getRoute()).append(" - ").append(race.getLength()).append(System.lineSeparator());
        performances.entrySet().stream().sorted((a, b) -> Integer.compare(b.getKey(), a.getKey())).limit(3)
                .forEach(c -> result.put(c.getKey(), c.getValue()));

        printPlacings(result, race, count, percent, sb);
        this.races.remove(id);
        return sb.toString();
    }

    private void printPlacings(Map<Integer, Car> result, Race race, int count, int percent, StringBuilder sb) {
        for (Map.Entry<Integer, Car> c : result.entrySet()) {
            switch (count) {
                case 1: percent = 50; break;
                case 2: percent = 70; break;
                case 3: percent = 80; break;
            }

            sb.append(count++).append(". ").append(c.getValue()
                    .getBrand()).append(" ").append(c.getValue().getModel())
                    .append(" ").append(c.getKey()).append("PP - $")
                    .append((race.getPrizePool() - ((race.getPrizePool() * percent) / 100)))
                    .append(System.lineSeparator());
        }
    }


    @Override
    public void park(int id) {
        if (!this.cars.get(id).participatesInARace()) {
            this.garage.park(id, this.cars.get(id));
        }
    }

    @Override
    public void unpark(int id) {
        this.garage.unpark(id, this.cars.get(id));
    }

    @Override
    public void tune(int tuneIndex, String addOn) {
        if (this.garage.getSize() > 0) {
            this.garage.tune(tuneIndex, addOn);
        }
    }
}
