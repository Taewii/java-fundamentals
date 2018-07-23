package app.factories;

import app.Constants;
import app.entities.race.*;

public class RaceFactory {
    public static Race create(String type, int length, String route, int prizePool, int extra) {

        switch (type) {
            case Constants.RACE_TYPE_CASUAL:
                return new CasualRace(length, route, prizePool);
            case Constants.RACE_TYPE_DRAG:
                return new DragRace(length, route, prizePool);
            case Constants.RACE_TYPE_DRIFT:
                return new DriftRace(length, route, prizePool);
            case Constants.RACE_TYPE_CIRCUIT:
                return new CircuitRace(length, route, prizePool, extra);
            case Constants.RACE_TYPE_TIME_LIMIT:
                return new TimeLimitRace(length, route, prizePool, extra);
            default:
                return null;
        }
    }
}
