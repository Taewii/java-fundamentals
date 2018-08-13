package P03_GraphicEditor.models;


import P03_GraphicEditor.interfaces.Drawable;

public class Circle extends Shape implements Drawable {

    @Override
    public String draw() {
        return "I am a Circle.";
    }
}
