package bg.softuni.utils;

public final class Constants {

    //Emergency messages
    public static final String PROPERTY_CREATION_MESSAGE = "Registered Public Property Emergency of level %s at %s.";
    public static final String HEALTH_CREATION_MESSAGE = "Registered Public Health Emergency of level %s at %s.";
    public static final String ORDER_CREATION_MESSAGE = "Registered Public Order Emergency of level %s at %s.";

    //EmergencyCenters messages
    public static final String FIRE_CENTER_CREATION_MESSAGE = "Registered Fire Service Emergency Center - %s.";
    public static final String MEDICAL_CENTER_CREATION_MESSAGE = "Registered Medical Service Emergency Center - %s.";
    public static final String POLICE_CENTER_CREATION_MESSAGE = "Registered Police Service Emergency Center - %s.";

    //Processing emergencies messages
    public static final String SUCCESSFUL_EMERGENCY_PROCESSING = "Successfully responded to all %s emergencies.";
    public static final String EMERGENCIES_LEFT_TO_PROCESS = "%s Emergencies left to process: %d.";

    //commands
    public static final String TERMINATING_COMMAND = "EmergencyBreak";

    public static final String REGISTER_PROPERTY_EMERGENCY = "RegisterPropertyEmergency";
    public static final String REGISTER_HEALTH_EMERGENCY = "RegisterHealthEmergency";
    public static final String REGISTER_ORDER_EMERGENCY = "RegisterOrderEmergency";

    public static final String REGISTER_FIRE_CENTER = "RegisterFireServiceCenter";
    public static final String REGISTER_MEDICAL_CENTER = "RegisterMedicalServiceCenter";
    public static final String REGISTER_POLICE_CENTER = "RegisterPoliceServiceCenter";

    public static final String PROCESS_EMERGENCIES = "ProcessEmergencies";
    public static final String EMERGENCY_REPORT = "EmergencyReport";

    private Constants() {
    }
}
