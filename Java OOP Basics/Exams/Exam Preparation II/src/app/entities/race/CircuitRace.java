package app.entities.race;

import app.interfaces.race.Track;

public class CircuitRace extends Race implements Track {

    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    public int getLaps() {
        return this.laps;
    }
}
