package app.interfaces.race;

import app.entities.car.Car;

import java.util.List;

public interface Track {

    int getLength();

    String getRoute();

    int getPrizePool();

    List<Car> getParticipants();
}
