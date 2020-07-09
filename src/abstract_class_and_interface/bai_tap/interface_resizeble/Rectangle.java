package abstract_class_and_interface.bai_tap.interface_resizeble;

public class Rectangle extends Shape implements Resizeable{
    private double width = 1.0;
    private double length = 1.0;
    private String color ="greed";
    private boolean filled= false;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        this.color=color;
        this.filled= filled;
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * this.length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getLength()
                + ", which is a subclass of "
                +", the Area=" + getArea()
                +", the Perimeter=" + getPerimeter()
                + super.toString();
    }
    @Override
    public void resize(double percent) {
        this.length += (percent / 100);
        this.width += (percent / 100);
    }
}
