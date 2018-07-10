package p02_method_overriding;

public class Rectangle {

    private double sideA;
    private double sideB;

    public Rectangle(double sideA) {
        this.sideA = sideA;
    }

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double area() {
        return this.sideA * this.sideB;
    }

    public double getSideA() {
        return this.sideA;
    }
}
