package P03_GraphicEditor;

import P03_GraphicEditor.models.Circle;
import P03_GraphicEditor.models.Rectangle;
import P03_GraphicEditor.models.Shape;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        Shape shape = new Shape();

        System.out.println(circle.draw());
        System.out.println(rectangle.draw());
        System.out.println(shape.draw());
    }
}
