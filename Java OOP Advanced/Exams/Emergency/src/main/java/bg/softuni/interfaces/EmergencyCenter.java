package bg.softuni.interfaces;

public interface EmergencyCenter {

    String getName();

    Integer getAmountOfMaximumEmergencies();

    Boolean isForRetirement();

    String managingEmergencyType();

    void processEmergency(Emergency emergency);
}
