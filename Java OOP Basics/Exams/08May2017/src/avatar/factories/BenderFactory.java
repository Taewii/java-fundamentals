package avatar.factories;

import avatar.entities.benders.*;

public class BenderFactory {
    public static Bender createBender(String type, String name, int power, double secondaryParameter) {
        switch (type) {
            case "Air":
                return new AirBender(name, power, secondaryParameter);
            case "Water":
                return new WaterBender(name, power, secondaryParameter);
            case "Fire":
                return new FireBender(name, power, secondaryParameter);
            case "Earth":
                return new EarthBender(name, power, secondaryParameter);
                default: return null;
        }
    }
}
