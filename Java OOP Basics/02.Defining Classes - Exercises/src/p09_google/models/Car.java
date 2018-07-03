package p09_google.models;

public class Car {

    private String model;
    private int speed;

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        if (this.model == null) {
            return "";
        }
        return String.format("%s %d%n", this.model, this.speed);
    }
}
