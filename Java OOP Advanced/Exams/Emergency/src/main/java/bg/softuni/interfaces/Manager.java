package bg.softuni.interfaces;

import bg.softuni.enums.EmergencyLevel;

public interface Manager {

    String registerPropertyEmergency(String description, EmergencyLevel level, Time registrationTime, int propertyDamage);

    String registerHealthEmergency(String description, EmergencyLevel level, Time registrationTime, int casualties);

    String registerOrderEmergency(String description, EmergencyLevel level, Time registrationTime, String status);

    String registerFireServiceCenter(String name, int amountOfEmergencies);

    String registerMedicalServiceCenter(String name, int amountOfEmergencies);

    String registerPoliceServiceCenter(String name, int amountOfEmergencies);

    String processEmergencies(String type);

    String emergencyReport();
}
