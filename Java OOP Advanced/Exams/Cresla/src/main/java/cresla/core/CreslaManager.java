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
    private Map<Integer, Module> modules; //todo figure out how to remove the ones that get removed when the capacity is reached
    private int id;

    public CreslaManager() {
        this.reactors = new LinkedHashMap<>();
        this.modules = new LinkedHashMap<>();
        this.id = 1;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        Reactor reactor = null;
        switch (arguments.get(0)) {
            case "Cryo":
                reactor = new CryoReactor(this.id++,
                        new ModuleContainer(Integer.parseInt(arguments.get(2))),
                        Integer.parseInt(arguments.get(1)));
                break;
            case "Heat":
                reactor = new HeatReactor(this.id++,
                        new ModuleContainer(Integer.parseInt(arguments.get(2))),
                        Integer.parseInt(arguments.get(1)));
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
        this.modules.put(module.getId(), module);
        return String.format(Constants.MODULE_CREATION_MESSAGE, arguments.get(1), module.getId(), arguments.get(0));
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int id = Integer.parseInt(arguments.get(0));

        if (this.reactors.containsKey(id)) {
            return this.reactors.get(id).toString();
        } else {
            return this.modules.get(id).toString();
        }
    }

    @Override
    public String exitCommand(List<String> arguments) {
        return null;
    }
}
