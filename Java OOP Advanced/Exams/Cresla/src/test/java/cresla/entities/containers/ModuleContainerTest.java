package cresla.entities.containers;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Module;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ModuleContainerTest {

    private Container container;
    private AbsorbingModule absorbingModule;
    private EnergyModule energyModule;

    @Before
    public void setUp() {
        this.container = new ModuleContainer(5);
        this.absorbingModule = Mockito.mock(AbsorbingModule.class);
        this.energyModule = Mockito.mock(EnergyModule.class);
    }

    @Test
    public void addEnergyModule() {
        this.container.addAbsorbingModule(this.absorbingModule);
        Map<Integer, AbsorbingModule> moduleList = null;

        try {
            Field modules = this.container.getClass().getDeclaredField("absorbingModules");
            modules.setAccessible(true);
            moduleList = (Map<Integer, AbsorbingModule>) modules.get(this.container);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(1, moduleList.size());
    }

    @Test
    public void addAbsorbingModule() {
        this.container.addEnergyModule(this.energyModule);
        Map<Integer, EnergyModule> moduleList = null;

        try {
            Field modules = this.container.getClass().getDeclaredField("energyModules");
            modules.setAccessible(true);
            moduleList = (Map<Integer, EnergyModule>) modules.get(this.container);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(1, moduleList.size());
    }

    @Test
    public void getTotalEnergyOutput() {
        EnergyModule mock1 = Mockito.mock(EnergyModule.class);
        EnergyModule mock2 = Mockito.mock(EnergyModule.class);
        Mockito.when(mock1.getEnergyOutput()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(mock2.getEnergyOutput()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.energyModule.getEnergyOutput()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(mock1.getId()).thenReturn(1);
        Mockito.when(mock2.getId()).thenReturn(2);
        Mockito.when(this.energyModule.getId()).thenReturn(3);

        this.container.addEnergyModule(mock1);
        this.container.addEnergyModule(mock2);
        this.container.addEnergyModule(this.energyModule);

        Assert.assertEquals(Integer.MAX_VALUE * 3L, this.container.getTotalEnergyOutput());
    }

    @Test
    public void getTotalHeatAbsorbing() {
        AbsorbingModule mock1 = Mockito.mock(AbsorbingModule.class);
        AbsorbingModule mock2 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(mock1.getHeatAbsorbing()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(mock2.getHeatAbsorbing()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.absorbingModule.getHeatAbsorbing()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(mock1.getId()).thenReturn(1);
        Mockito.when(mock2.getId()).thenReturn(2);
        Mockito.when(this.energyModule.getId()).thenReturn(3);

        this.container.addAbsorbingModule(mock1);
        this.container.addAbsorbingModule(mock2);
        this.container.addAbsorbingModule(this.absorbingModule);

        Assert.assertEquals(Integer.MAX_VALUE * 3L, this.container.getTotalHeatAbsorbing());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullAbsorbingModule() {
        this.container.addAbsorbingModule(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullEnergyModule() {
        this.container.addEnergyModule(null);
    }

    @Test
    public void testRemovingElementAfterReachedMaximumCapacity() {
        AbsorbingModule mock1 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(mock1.getId()).thenReturn(1);
        AbsorbingModule mock2 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(mock2.getId()).thenReturn(2);
        AbsorbingModule mock3 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(mock3.getId()).thenReturn(3);
        EnergyModule mock4 = Mockito.mock(EnergyModule.class);
        Mockito.when(mock4.getId()).thenReturn(4);
        EnergyModule mock5 = Mockito.mock(EnergyModule.class);
        Mockito.when(mock5.getId()).thenReturn(5);
        EnergyModule mock6 = Mockito.mock(EnergyModule.class);
        Mockito.when(mock6.getId()).thenReturn(6);

        this.container.addAbsorbingModule(mock1);
        this.container.addAbsorbingModule(mock2);
        this.container.addAbsorbingModule(mock3);
        this.container.addEnergyModule(mock4);
        this.container.addEnergyModule(mock5);
        this.container.addEnergyModule(mock6);

        List<Module> moduleList = null;

        try {
            Field modules = this.container.getClass().getDeclaredField("modulesByInput");
            modules.setAccessible(true);
            moduleList = (List<Module>) modules.get(this.container);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(5, moduleList.size());

        EnergyModule mock7 = Mockito.mock(EnergyModule.class);
        Mockito.when(mock7.getId()).thenReturn(7);
        this.container.addEnergyModule(mock7);
        Assert.assertEquals(5, moduleList.size());
    }

    @Test
    public void testIfAbsorbedModuesIsRemoved() {
        AbsorbingModule mock1 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(mock1.getHeatAbsorbing()).thenReturn(1);
        EnergyModule mock2 = Mockito.mock(EnergyModule.class);
        Mockito.when(mock2.getId()).thenReturn(2);
        EnergyModule mock3 = Mockito.mock(EnergyModule.class);
        Mockito.when(mock3.getId()).thenReturn(3);
        EnergyModule mock4 = Mockito.mock(EnergyModule.class);
        Mockito.when(mock4.getId()).thenReturn(4);
        EnergyModule mock5 = Mockito.mock(EnergyModule.class);
        Mockito.when(mock5.getId()).thenReturn(5);
        EnergyModule mock6 = Mockito.mock(EnergyModule.class);
        Mockito.when(mock6.getId()).thenReturn(6);
        this.container.addAbsorbingModule(mock1);
        this.container.addEnergyModule(mock2);
        this.container.addEnergyModule(mock3);
        this.container.addEnergyModule(mock4);
        this.container.addEnergyModule(mock5);
        this.container.addEnergyModule(mock6);

        Map<Integer, AbsorbingModule> moduleList = null;
        try {
            Field modules = this.container.getClass().getDeclaredField("absorbingModules");
            modules.setAccessible(true);
            moduleList = (Map<Integer, AbsorbingModule>) modules.get(this.container);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(0, moduleList.size());
    }

    @Test
    public void testIfEnergyModuesIsRemoved() {
        EnergyModule mock1 = Mockito.mock(EnergyModule.class);
        Mockito.when(mock1.getId()).thenReturn(1);
        AbsorbingModule mock2 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(mock2.getId()).thenReturn(2);
        AbsorbingModule mock3 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(mock3.getId()).thenReturn(3);
        AbsorbingModule mock4 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(mock4.getId()).thenReturn(4);
        AbsorbingModule mock5 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(mock5.getId()).thenReturn(5);
        AbsorbingModule mock6 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(mock6.getId()).thenReturn(6);
        this.container.addEnergyModule(mock1);
        this.container.addAbsorbingModule(mock2);
        this.container.addAbsorbingModule(mock3);
        this.container.addAbsorbingModule(mock4);
        this.container.addAbsorbingModule(mock5);
        this.container.addAbsorbingModule(mock6);

        Map<Integer, EnergyModule> moduleList = null;
        try {
            Field modules = this.container.getClass().getDeclaredField("energyModules");
            modules.setAccessible(true);
            moduleList = (Map<Integer, EnergyModule>) modules.get(this.container);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(0, moduleList.size());
    }
}