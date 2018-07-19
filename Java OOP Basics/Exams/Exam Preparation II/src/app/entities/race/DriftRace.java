package app.entities.race;

import app.interfaces.race.Track;

public class DriftRace extends Race implements Track {
    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }
}
