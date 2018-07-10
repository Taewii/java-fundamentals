package p03_shapes;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5d, 10d);
        Shape circle = new Circle(2.15);

        rectangle.calculateArea();
        rectangle.calculatePerimeter();
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());

        circle.calculateArea();
        circle.calculatePerimeter();
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
    }
}
