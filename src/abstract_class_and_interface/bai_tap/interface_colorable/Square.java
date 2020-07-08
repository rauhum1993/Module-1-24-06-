package abstract_class_and_interface.bai_tap.interface_colorable;

public class Square extends Shape {
    private double side;
    public Square() {
    }
    public Square(double side) {
        this.side = side;
    }
    public Square(double side, String color, boolean filled) {
        super(color,filled);
        this.side = side;
    }
    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
    }
    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", subclass of shape "
                + super.toString()
                + ", Area=" +
                + getArea();
    }
    double getArea() {
        return side * side;
    }

    @Override
    public void howToColor() {
        super.howToColor();
    }
}
