package app.factories;

import app.entities.*;

public class ColonistFactory {

    public ColonistFactory() {
    }

    public static Colonist createColonist(String clazz, String colonistId, String familyId, int talent, int age, String sign) {
        switch (clazz) {
            case "GeneralPractitioner":
                return new GeneralPractitioner(colonistId, familyId, talent, age, sign);
            case "Surgeon":
                return new Surgeon(colonistId, familyId, talent, age, sign);
                default: return null;
        }
    }

    public static Colonist createColonist(String clazz, String colonistId, String familyId, int talent, int age) {
        switch (clazz) {
            case "Soldier":
                return new Soldier(colonistId, familyId, talent, age);
            case "SoftwareEngineer":
                return new SoftwareEngineer(colonistId, familyId, talent, age);
            case "HardwareEngineer":
                return new HardwareEngineer(colonistId, familyId, talent, age);
            default: return null;
        }
    }
}
