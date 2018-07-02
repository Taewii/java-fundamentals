package p06_raw_data.models;

import java.util.List;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tyre> tyre;

    public Car(String model, Engine engine, Cargo cargo, List<Tyre> tyre) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyre = tyre;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public List<Tyre> getTyre() {
        return this.tyre;
    }

    public Engine getEngine() {
        return this.engine;
    }

    @Override
    public String toString() {
        return String.format("%s", this.model);
    }
}
