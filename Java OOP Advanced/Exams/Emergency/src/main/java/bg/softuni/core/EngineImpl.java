package bg.softuni.core;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.interfaces.*;
import bg.softuni.utils.RegistrationTime;

import static bg.softuni.utils.Constants.*;

public class EngineImpl implements Engine {

    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;

    public EngineImpl(InputReader reader, OutputWriter writer, Manager manager) {
        this.reader = reader;
        this.writer = writer;
        this.manager = manager;
    }

    @Override
    public void run() {
        String input;
        while (!TERMINATING_COMMAND.equals(input = this.reader.readLine())) {
            String[] tokens = input.split("\\|");
            String result = "";

            switch (tokens[0]) {
                case REGISTER_PROPERTY_EMERGENCY:
                    result = this.manager.registerPropertyEmergency(tokens[1],
                            getEmergencyLevel(tokens[2]), new RegistrationTime(tokens[3]), Integer.parseInt(tokens[4]));
                    break;
                case REGISTER_HEALTH_EMERGENCY:
                    result = this.manager.registerHealthEmergency(tokens[1],
                            getEmergencyLevel(tokens[2]), new RegistrationTime(tokens[3]), Integer.parseInt(tokens[4]));
                    break;
                case REGISTER_ORDER_EMERGENCY:
                    result = this.manager.registerOrderEmergency(tokens[1],
                            getEmergencyLevel(tokens[2]), new RegistrationTime(tokens[3]), tokens[4]);
                    break;
                case REGISTER_FIRE_CENTER:
                    result = this.manager.registerFireServiceCenter(tokens[1], Integer.parseInt(tokens[2]));
                    break;
                case REGISTER_MEDICAL_CENTER:
                    result = this.manager.registerMedicalServiceCenter(tokens[1], Integer.parseInt(tokens[2]));
                    break;
                case REGISTER_POLICE_CENTER:
                    result = this.manager.registerPoliceServiceCenter(tokens[1], Integer.parseInt(tokens[2]));
                    break;
                case PROCESS_EMERGENCIES:
                    result = this.manager.processEmergencies(tokens[1]);
                    break;
                case EMERGENCY_REPORT:
                    result = this.manager.emergencyReport();
                    break;
            }

            this.writer.writeLine(result);
        }
    }

    private EmergencyLevel getEmergencyLevel(String level) {
        switch (level) {
            case "Minor":
                return EmergencyLevel.MINOR;
            case "Major":
                return EmergencyLevel.MAJOR;
            case "Disaster":
                return EmergencyLevel.DISASTER;
        }
        return null;
    }
}
