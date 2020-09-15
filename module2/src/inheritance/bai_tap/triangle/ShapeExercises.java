package inheritance.bai_tap.triangle;

public class ShapeExercises {
    private double x=1.0;
    private double y=1.0;

    public ShapeExercises() {
    }

    public ShapeExercises(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "x=" + getX() +
                ", y=" + getY() +
                '}';
    }
}
