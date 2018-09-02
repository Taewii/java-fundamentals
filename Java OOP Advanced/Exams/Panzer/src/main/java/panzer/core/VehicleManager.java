package panzer.core;

import panzer.Constants;
import panzer.contracts.BattleOperator;
import panzer.contracts.Manager;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;
import panzer.models.parts.ArsenalPart;
import panzer.models.parts.EnduranePart;
import panzer.models.parts.ShellPart;
import panzer.models.vehicles.Revenger;
import panzer.models.vehicles.Vanguard;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VehicleManager implements Manager {

    private Map<String, Vehicle> vehicles;
    private Map<String, Part> parts;
    private BattleOperator battleOperator;

    public VehicleManager(BattleOperator battleOperator) {
        this.battleOperator = battleOperator;
        this.vehicles = new LinkedHashMap<>();
        this.parts = new LinkedHashMap<>();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        Vehicle vehicle = null;

        switch (arguments.get(0)) {
            case "Vanguard":
                vehicle = new Vanguard(
                        arguments.get(1),
                        Double.parseDouble(arguments.get(2)),
                        new BigDecimal(arguments.get(3)),
                        Integer.parseInt(arguments.get(4)),
                        Integer.parseInt(arguments.get(5)),
                        Integer.parseInt(arguments.get(6)),
                        new VehicleAssembler());
                break;
            case "Revenger":
                vehicle = new Revenger(
                        arguments.get(1),
                        Double.parseDouble(arguments.get(2)),
                        new BigDecimal(arguments.get(3)),
                        Integer.parseInt(arguments.get(4)),
                        Integer.parseInt(arguments.get(5)),
                        Integer.parseInt(arguments.get(6)),
                        new VehicleAssembler());
                break;
        }

        this.vehicles.put(vehicle.getModel(), vehicle);
        return String.format(Constants.VEHICLE_CREATION_MESSAGE, vehicle.getClass().getSimpleName(), vehicle.getModel());
    }

    @Override
    public String addPart(List<String> arguments) {
        Vehicle vehicle = this.vehicles.get(arguments.get(0));
        Part part = null;

        switch (arguments.get(1)) {
            case "Arsenal":
                part = new ArsenalPart(arguments.get(2),
                        Double.parseDouble(arguments.get(3)),
                        new BigDecimal(arguments.get(4)),
                        Integer.parseInt(arguments.get(5)));
                vehicle.addArsenalPart(part);
                break;
            case "Shell":
                part = new ShellPart(arguments.get(2),
                        Double.parseDouble(arguments.get(3)),
                        new BigDecimal(arguments.get(4)),
                        Integer.parseInt(arguments.get(5)));
                vehicle.addShellPart(part);
                break;
            case "Endurance":
                part = new EnduranePart(arguments.get(2),
                        Double.parseDouble(arguments.get(3)),
                        new BigDecimal(arguments.get(4)),
                        Integer.parseInt(arguments.get(5)));
                vehicle.addEndurancePart(part);
                break;
        }

        this.parts.put(part.getModel(), part);
        return String.format(Constants.PART_CREATION_MESSAGE,
                part.getClass().getSimpleName().replace("Part", ""),
                part.getModel(),
                vehicle.getModel());
    }

    @Override
    public String inspect(List<String> arguments) {
        String model = arguments.get(0);
        if (this.vehicles.containsKey(model)) {
            return this.vehicles.get(model).toString();
        }

        if (this.parts.containsKey(model)) {
            return this.parts.get(model).toString();
        }

        return null;
    }

    @Override
    public String battle(List<String> arguments) {
        Vehicle attacker = this.vehicles.get(arguments.get(0));
        Vehicle target = this.vehicles.get(arguments.get(1));
        String winner = this.battleOperator.battle(attacker, target);

        if (winner.equals(attacker.getModel())) {
            this.vehicles.remove(target.getModel());
        } else {
            this.vehicles.remove(attacker.getModel());
        }

        return String.format(Constants.BATTLE_MESSAGE, attacker.getModel(), target.getModel(), winner);
    }

    @Override
    public String terminate(List<String> arguments) {
        return null;
    }
}
