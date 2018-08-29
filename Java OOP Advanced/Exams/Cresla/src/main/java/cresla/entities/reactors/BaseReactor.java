package cresla.entities.reactors;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;

import java.lang.reflect.Field;
import java.util.List;

public abstract class BaseReactor implements Reactor {

    private int id;
    private Container moduleContainer;

    protected BaseReactor(int id, Container moduleContainer) {
        this.id = id;
        this.moduleContainer = moduleContainer;
    }

    @Override
    public long getTotalEnergyOutput() {
        long energyOutput = this.getEnergy();
        long heatAbsorbing = this.getTotalHeatAbsorbing();

        return energyOutput > heatAbsorbing ? 0L : energyOutput;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.moduleContainer.getTotalHeatAbsorbing();
    }

    @Override
    @SuppressWarnings("unchecked")
    public int getModuleCount() {
        try {
            Field modulesByInput = this.moduleContainer.getClass().getDeclaredField("modulesByInput");
            modulesByInput.setAccessible(true);
            List<Module> modules = (List<Module>) modulesByInput.get(this.moduleContainer);
            return modules.size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.moduleContainer.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.moduleContainer.addAbsorbingModule(absorbingModule);
    }

    protected long getEnergy() {
        return this.moduleContainer.getTotalEnergyOutput();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s - %d%n", this.getClass().getSimpleName(), this.id));
        sb.append(String.format("Energy Output: %d%n", this.getTotalEnergyOutput()));
        sb.append(String.format("Heat Absorbing: %d%n", this.getTotalHeatAbsorbing()));
        sb.append(String.format("Modules: %d", this.getModuleCount()));

        return sb.toString();
    }
}
