package bg.softuni.interfaces;

public interface Register {

    Emergency dequeueEmergency();

    Emergency peekEmergency();

    void enqueueEmergency(Emergency emergency);

    Boolean isEmpty();

    Boolean containsEmergencyType(String type);

    int amountEmergenciesLeftFromType(String type);
}
