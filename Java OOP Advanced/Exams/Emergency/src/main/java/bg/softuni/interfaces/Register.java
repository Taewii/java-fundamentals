package bg.softuni.interfaces;

import bg.softuni.models.emergencies.BaseEmergency;

public interface Register {

    Emergency dequeueEmergency();

    Emergency peekEmergency();

    void enqueueEmergency(Emergency emergency);
}
