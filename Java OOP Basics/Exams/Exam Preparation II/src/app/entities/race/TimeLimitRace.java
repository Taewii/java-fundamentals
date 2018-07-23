package app.entities.race;

import app.interfaces.race.Track;

public class TimeLimitRace extends Race implements Track {

    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    public int getGoldTime() {
        return this.goldTime;
    }
}
