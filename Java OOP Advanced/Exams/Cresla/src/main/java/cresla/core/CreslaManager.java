package cresla.core;

import cresla.Constants;
import cresla.entities.containers.ModuleContainer;
import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CreslaManager implements Manager {

    private Map<Integer, Reactor> reactors;
    private Map<Integer, Module> allModules;
    private int id;

    public CreslaManager() {
        this.reactors = new LinkedHashMap<>();
        this.allModules = new LinkedHashMap<>();
        this.id = 1;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        Reactor reactor = null;
        int additionalParameter = Integer.parseInt(arguments.get(1));
        int moduleCapacity = Integer.parseInt(arguments.get(2));
        switch (arguments.get(0)) {
            case "Cryo":
                reactor = new CryoReactor(this.id++, new ModuleContainer(moduleCapacity), additionalParameter);
                break;
            case "Heat":
                reactor = new HeatReactor(this.id++, new ModuleContainer(moduleCapacity), additionalParameter);
                break;
        }
        this.reactors.put(reactor.getId(), reactor);

        return String.format(Constants.REACTOR_CREATION_MESSAGE, arguments.get(0), reactor.getId());
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        Reactor reactor = this.reactors.get(Integer.parseInt(arguments.get(0)));
        Module module = null;
        int additionalParameter = Integer.parseInt(arguments.get(2));

        switch (arguments.get(1)) {
            case "CryogenRod":
                module = new CryogenRod(this.id++, additionalParameter);
                reactor.addEnergyModule((EnergyModule) module);
                break;
            case "CooldownSystem":
                module = new CooldownSystem(this.id++, additionalParameter);
                reactor.addAbsorbingModule((AbsorbingModule) module);
                break;
            case "HeatProcessor":
                module = new HeatProcessor(this.id++, additionalParameter);
                reactor.addAbsorbingModule((AbsorbingModule) module);
                break;
        }
        this.allModules.put(module.getId(), module);

        return String.format(Constants.MODULE_CREATION_MESSAGE, arguments.get(1), module.getId(), arguments.get(0));
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int id = Integer.parseInt(arguments.get(0));

        if (this.reactors.containsKey(id)) {
            return this.reactors.get(id).toString();
        } else {
            return this.allModules.get(id).toString();
        }
    }

    private long getTotalEnergyOutput() {
        return this.reactors.values().stream().mapToLong(Reactor::getTotalEnergyOutput).sum();
    }

    private long getTotalHeatAbsorbing() {
        return this.reactors.values().stream().mapToLong(Reactor::getTotalHeatAbsorbing).sum();
    }

    @Override
    public String exitCommand(List<String> arguments) {
        StringBuilder sb = new StringBuilder();
        int cryoReactors = 0;
        int heatReactors = 0;
        int energyModules = 0;
        int absorbingModules = 0;

        for (Reactor reactor : this.reactors.values()) {
            if (reactor instanceof CryoReactor) {
                cryoReactors++;
            } else {
                heatReactors++;
            }
        }

        for (Module module : this.allModules.values()) {
            if (module instanceof CryogenRod) {
                energyModules++;
            } else {
                absorbingModules++;
            }
        }

        sb.append(String.format("Cryo Reactors: %d%n", cryoReactors));
        sb.append(String.format("Heat Reactors: %d%n", heatReactors));
        sb.append(String.format("Energy Modules: %d%n", energyModules));
        sb.append(String.format("Absorbing Modules: %d%n", absorbingModules));
        sb.append(String.format("Total Energy Output: %d%n", this.getTotalEnergyOutput()));
        sb.append(String.format("Total Heat Absorbing: %d", this.getTotalHeatAbsorbing()));

        return sb.toString();
    }
}
