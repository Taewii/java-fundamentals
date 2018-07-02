package p07_car_salesman.models;

public class Engine {

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.model).append(":")
                .append(System.lineSeparator());
        sb.append("Power: ").append(this.power)
                .append(System.lineSeparator());
        sb.append("Displacement: ").append(this.displacement == 0 ? "n/a" : this.displacement)
                .append(System.lineSeparator());
        sb.append("Efficiency: ").append(this.efficiency == null ? "n/a" : this.efficiency)
                .append(System.lineSeparator());
        return sb.toString();
    }
}
