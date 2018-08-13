package P05_Square;

import P05_Square.interfaces.Shape;
import P05_Square.models.Rectangle;
import P05_Square.models.Square;

public class Main {
    public static void main(String[] args) {
        Square square = new Square();
        square.setHeight(5);
        square.setWidth(10);

        Shape rectangle = new Rectangle();
        rectangle.setHeight(5);
        rectangle.setWidth(10);

        System.out.println(square.getArea());
        System.out.println(rectangle.getArea());
    }
}
