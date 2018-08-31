package panzer.core;

import panzer.contracts.Manager;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VehicleManager implements Manager {

    private Map<String, Vehicle> vehicles;
    private Map<String, Part> parts;

    public VehicleManager() {
        this.vehicles = new LinkedHashMap<>();
        this.parts = new LinkedHashMap<>();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        return null;
    }

    @Override
    public String addPart(List<String> arguments) {
        return null;
    }

    @Override
    public String inspect(List<String> arguments) {
        return null;
    }

    @Override
    public String battle(List<String> arguments) {
        return null;
    }

    @Override
    public String terminate(List<String> arguments) {
        return null;
    }
}
