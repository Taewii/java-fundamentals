package p01_class_box;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Surface Area - %.2f%n",
                ((this.length * this.width) * 2) + ((this.length * this.height) * 2) + ((this.width * this.height) * 2)));
        sb.append(String.format("Lateral Surface Area - %.2f%n",
                ((this.length * this.height) * 2) + ((this.width * this.height) * 2)));
        sb.append(String.format("Volume - %.2f",
                this.length * this.width * this.height));

        return sb.toString();
    }
}
