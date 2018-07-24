package avatar.factories;

import avatar.entities.monuments.*;

public class MonumentFactory {
    public static Monument createMonument(String type, String name, int affinity) {
        switch (type) {
            case "Fire":
                return new FireMonument(name, affinity);
            case "Air":
                return new AirMonument(name, affinity);
            case "Water":
                return new WaterMonument(name, affinity);
            case "Earth":
                return new EarthMonument(name, affinity);
            default:
                return null;
        }
    }
}
