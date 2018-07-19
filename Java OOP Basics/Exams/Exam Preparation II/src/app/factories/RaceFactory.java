package app.factories;

import app.Constants;
import app.entities.race.CasualRace;
import app.entities.race.DragRace;
import app.entities.race.DriftRace;
import app.entities.race.Race;

public class RaceFactory {
    public static Race create(String type, int length, String route, int prizePool) {

        switch (type) {
            case Constants.RACE_TYPE_CASUAL:
                return new CasualRace(length, route, prizePool);
            case Constants.RACE_TYPE_DRAG:
                return new DragRace(length, route, prizePool);
            case Constants.RACE_TYPE_DRIFT:
                return new DriftRace(length, route, prizePool);
            default:
                return null;
        }
    }
}
