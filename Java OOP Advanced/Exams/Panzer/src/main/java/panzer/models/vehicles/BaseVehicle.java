package panzer.models.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
        return this.vehicleAssembler.getTotalWeight() + this.weight;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.vehicleAssembler.getTotalPrice().add(this.price);
    }

    @Override
    public long getTotalAttack() {
        return this.vehicleAssembler.getTotalAttackModification() + this.attack;
    }

    @Override
    public long getTotalDefense() {
        return this.vehicleAssembler.getTotalDefenseModification() + this.defence;
    }

    @Override
    public long getTotalHitPoints() {
        return this.vehicleAssembler.getTotalHitPointModification() + this.hitPoints;
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
    @SuppressWarnings("unchecked")
    public Iterable<Part> getParts() {
        List<Part> parts = null;

        try {
            Field allParts = this.vehicleAssembler.getClass().getDeclaredField("allParts");
            allParts.setAccessible(true);
           parts = (List<Part>) allParts.get(this.vehicleAssembler);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return parts;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<String> partModels = new ArrayList<>();
        Iterable<Part> parts = this.getParts();

        for (Part part : parts) {
            partModels.add(part.getModel());
        }

        sb.append(String.format("%s - %s%n", this.getClass().getSimpleName(), this.getModel()));
        sb.append(String.format("Total Weight: %.3f%n", this.getTotalWeight()));
        sb.append(String.format("Total Price: %.3f%n", this.getTotalPrice()));
        sb.append(String.format("Attack: %d%n", this.getTotalAttack()));
        sb.append(String.format("Defence: %d%n", this.getTotalDefense()));
        sb.append(String.format("HitPoints: %d%n", this.getTotalHitPoints()));
        sb.append("Parts: ").append(partModels.isEmpty() ? "None" : String.join(", ", partModels));

        return sb.toString();
    }
}
