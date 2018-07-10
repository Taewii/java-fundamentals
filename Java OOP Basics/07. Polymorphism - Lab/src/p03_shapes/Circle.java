package p03_shapes;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return this.radius;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * Math.PI * getRadius());
    }

    @Override
    protected void calculateArea() {
        setArea(Math.PI * (getRadius() * getRadius()));
    }
}
