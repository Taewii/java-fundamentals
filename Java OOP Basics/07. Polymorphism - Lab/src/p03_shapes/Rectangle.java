package p03_shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return this.height;
    }

    public Double getWidth() {
        return this.width;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(getHeight() * 2 + getWidth() * 2);
    }

    @Override
    protected void calculateArea() {
        setArea(getHeight() * getWidth());
    }
}
