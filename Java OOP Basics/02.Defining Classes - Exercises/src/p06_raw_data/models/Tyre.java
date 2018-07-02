package p06_raw_data.models;

public class Tyre {

    private double pressure;
    private int age;

    public Tyre(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure() {
        return this.pressure;
    }
}
