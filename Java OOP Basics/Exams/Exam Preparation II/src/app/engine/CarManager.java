package app.engine;

import app.entities.garage.Garage;
import app.entities.race.CircuitRace;
import app.entities.race.Race;
import app.entities.race.TimeLimitRace;
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

    public CarManager() {
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
    public void open(int id, String type, int length, String route, int prizePool, int extra) {
        Race race = RaceFactory.create(type, length, route, prizePool, extra);

        if (race != null) {
            this.races.put(id, race);
        }
    }

    @Override
    public void open(int id, String type, int length, String route, int prizePool) {
        Race race = RaceFactory.create(type, length, route, prizePool, 0);

        if (race != null) {
            this.races.put(id, race);
        }
    }

    @Override
    public void participate(int carId, int raceId) {
        if (!isCarParked(carId)) {
            if (this.races.get(raceId).getClass().getSimpleName().equals("TimeLimitRace")) {
                if (this.races.get(raceId).getSize() == 0) {
                    this.races.get(raceId).addParticipant(this.cars.get(carId));
                }
            } else {
                this.races.get(raceId).addParticipant(this.cars.get(carId));
            }
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
                case "TimeLimitRace":
                    return calculateTimeLimitRace(id);
                case "CircuitRace":
                    return calculateCircuitRace(id);
            }
        } else {
            return String.format("Cannot start the race with zero participants.%n");
        }
        return null;
    }

    @Override
    public String calculateCircuitRace(int id) {
        Map<Integer, Car> performances = new LinkedHashMap<>();
        Map<Integer, Car> result = new LinkedHashMap<>();
        Race race = this.races.get(id);
        int laps = ((CircuitRace) race).getLaps();
        int durabilityLoss = (race.getLength() * race.getLength()) * laps;
        int count = 1;
        int percent = 0;
        for (Car car : race.getParticipants()) {
            car.removeDurability(durabilityLoss);
            int performance = (car.getHorsepower() / car.getAcceleration()) + (car.getSuspension() + car.getDurability());
            performances.put(performance, car);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(race.getRoute()).append(" - ").append(race.getLength() * laps).append(System.lineSeparator());
        performances.entrySet().stream().sorted((a, b) -> Integer.compare(b.getKey(), a.getKey())).limit(4)
                .forEach(c -> result.put(c.getKey(), c.getValue()));

        for (Map.Entry<Integer, Car> c : result.entrySet()) {
            switch (count) {
                case 1:
                    percent = 60;
                    break;
                case 2:
                    percent = 70;
                    break;
                case 3:
                    percent = 80;
                    break;
                case 4:
                    percent = 90;
                    break;
            }

            sb.append(count++).append(". ").append(c.getValue()
                    .getBrand()).append(" ").append(c.getValue().getModel())
                    .append(" ").append(c.getKey()).append("PP - $")
                    .append((race.getPrizePool() - ((race.getPrizePool() * percent) / 100)))
                    .append(System.lineSeparator());
        }

        this.races.remove(id);
        return sb.toString();
    }

    @Override
    public String calculateTimeLimitRace(int id) {
        Race race = this.races.get(id);
        Car car = race.getParticipants().get(0);
        int timePerformance = race.getLength() * ((car.getHorsepower() / 100) * car.getAcceleration());
        String award = "";
        int prize = 0;

        if (timePerformance <= ((TimeLimitRace) race).getGoldTime()) {
            award = "Gold";
            prize = race.getPrizePool();
        } else if (timePerformance <= ((TimeLimitRace) race).getGoldTime() + 15) {
            award = "Silver";
            prize = race.getPrizePool() - ((race.getPrizePool() * 50) / 100);
        } else if (timePerformance > ((TimeLimitRace) race).getGoldTime() + 15) {
            award = "Bronze";
            prize = race.getPrizePool() - ((race.getPrizePool() * 70) / 100);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(race.getRoute()).append(" - ").append(race.getLength()).append(System.lineSeparator());
        sb.append(String.format("%s %s - %d s.%n", car.getBrand(), car.getModel(), timePerformance));
        sb.append(String.format("%s Time, $%d.%n", award, prize));
        return sb.toString();
    }

    @Override
    public String calculateDriftRace(int id) {
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

    @Override
    public String calculateDragRace(int id) {
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

    @Override
    public String calculateCasualRace(int id) {
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

    @Override
    public void printPlacings(Map<Integer, Car> result, Race race, int count, int percent, StringBuilder sb) {
        for (Map.Entry<Integer, Car> c : result.entrySet()) {
            switch (count) {
                case 1:
                    percent = 50;
                    break;
                case 2:
                    percent = 70;
                    break;
                case 3:
                    percent = 80;
                    break;
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
        if (!isCarInARace(id)) {
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

    @Override
    public boolean isCarInARace(int id) {
        Car car = this.cars.get(id);
        for (Race race : races.values()) {
            for (Car currentCar : race.getParticipants()) {
                if (currentCar.equals(car)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isCarParked(int id) {
        Car car = this.cars.get(id);
        for (Car currentCar : this.garage.getParkedCars().values()) {
            if (currentCar.equals(car)) {
                return true;
            }
        }
        return false;
    }
}
