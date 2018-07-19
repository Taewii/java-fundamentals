package app.entities.race;

import app.interfaces.race.Track;

public class CasualRace extends Race implements Track {

    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }
}
