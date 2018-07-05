package p02_class_box_data_validation;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
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
