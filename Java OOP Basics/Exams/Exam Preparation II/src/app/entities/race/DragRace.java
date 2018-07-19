package app.entities.race;

import app.interfaces.race.Track;

public class DragRace extends Race implements Track {
    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }
}
