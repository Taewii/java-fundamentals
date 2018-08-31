package panzer.models.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;

import java.math.BigDecimal;

public abstract class BaseVehicle implements Vehicle {

    private String model;
    private double weight;
    private BigDecimal price;
    private int attack;
    private int defence;
    private int hitPoints;
    private Assembler vehicleAssembler;

    protected BaseVehicle(String model, double weight, BigDecimal price, int attack,
                       int defence, int hitPoints, Assembler vehicleAssembler) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;
        this.vehicleAssembler = vehicleAssembler;
    }

    @Override
    public double getTotalWeight() {
        return this.vehicleAssembler.getTotalWeight();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.vehicleAssembler.getTotalPrice();
    }

    @Override
    public long getTotalAttack() {
        return this.vehicleAssembler.getTotalAttackModification();
    }

    @Override
    public long getTotalDefense() {
        return this.vehicleAssembler.getTotalDefenseModification();
    }

    @Override
    public long getTotalHitPoints() {
        return this.vehicleAssembler.getTotalHitPointModification();
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.vehicleAssembler.addArsenalPart(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.vehicleAssembler.addShellPart(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.vehicleAssembler.addEndurancePart(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        return null; //todo
    }

    @Override
    public String getModel() {
        return this.model;
    }
}
