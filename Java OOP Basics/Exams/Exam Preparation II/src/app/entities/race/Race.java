package app.entities.race;

import app.entities.car.Car;
import app.interfaces.race.Track;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Race implements Track {

    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    public Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public String getRoute() {
        return this.route;
    }

    @Override
    public int getPrizePool() {
        return this.prizePool;
    }

    @Override
    public List<Car> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }
}
